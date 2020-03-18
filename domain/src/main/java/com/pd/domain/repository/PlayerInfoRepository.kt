package com.pd.domain.repository

import com.pd.domain.entities.PlayerEntity
import io.reactivex.rxjava3.core.Observable

interface PlayerInfoRepository {

    fun playerInfo(playerName: String) : Observable<PlayerEntity>
}