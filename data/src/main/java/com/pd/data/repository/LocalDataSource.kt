package com.pd.data.repository

import com.pd.data.models.PlayerData
import io.reactivex.rxjava3.core.Observable

interface LocalDataSource {
    fun getPlayerInfo(identifier: String): Observable<PlayerData>
}