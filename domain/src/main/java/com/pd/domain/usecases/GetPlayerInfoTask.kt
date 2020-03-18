package com.pd.domain.usecases

import com.pd.domain.entities.PlayerEntity
import com.pd.domain.qualifiers.Background
import com.pd.domain.qualifiers.Foreground
import com.pd.domain.repository.PlayerInfoRepository
import com.pd.domain.usecases.base.ObservableUseCase
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import java.lang.IllegalArgumentException
import javax.inject.Inject

class GetPlayerInfoTask @Inject constructor(
    private val playerInfoRepository: PlayerInfoRepository,
    @Background backgroundScheduler: Scheduler,
    @Foreground foregroundScheduler: Scheduler
): ObservableUseCase<PlayerEntity, String>(backgroundScheduler, foregroundScheduler) {

    override fun generateObservable(input: String?): Observable<PlayerEntity> {
        if(input == null){
            throw IllegalArgumentException("Player identifier cannot be null")
        }
        return playerInfoRepository.playerInfo(input)
    }
}