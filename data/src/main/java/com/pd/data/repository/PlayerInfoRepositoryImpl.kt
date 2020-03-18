package com.pd.data.repository

import com.pd.data.mapper.PlayerDataMapper
import com.pd.domain.entities.PlayerEntity
import com.pd.domain.repository.PlayerInfoRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class PlayerInfoRepositoryImpl @Inject constructor(
    private val playerDataMapper: PlayerDataMapper,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : PlayerInfoRepository {
    override fun playerInfo(playerName: String): Observable<PlayerEntity> {

        val playerInfoObservable = localDataSource.getPlayerInfo(playerName)
            .map {
                playerDataMapper.from(it) }

        return remoteDataSource.getPlayerInfo(playerName)
            .map {
                playerDataMapper.from(it)
            }.concatWith(playerInfoObservable)
    }
}