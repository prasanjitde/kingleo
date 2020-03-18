package com.pd.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.pd.domain.usecases.GetPlayerInfoTask
import com.pd.presentation.mapper.PlayerInfoMapper
import com.pd.presentation.model.PlayerInfo
import com.pd.presentation.model.Resource
import com.pd.presentation.qualifier.PlayerIdentity
import io.reactivex.rxjava3.core.BackpressureStrategy
import javax.inject.Inject

class PlayerVM @Inject internal constructor(
    @PlayerIdentity private val playerIdentifier: String,
    private val playerInfoMapper: PlayerInfoMapper,
    private val getPlayerInfoTask: GetPlayerInfoTask
) : ViewModel() {
    val playerInfoResource: LiveData<Resource<PlayerInfo>>
        get() = getPlayerInfoTask
            .buildUseCase(playerIdentifier)
            .map { playerInfoMapper.to(it) }
            .map { Resource.success(it) }
            // .startWith(Resource.loading())
            /*.onErrorResumeNext(
                Function {
                    Observable.just(Resource.error(it.localizedMessage))
                }
            )*/
            .toFlowable(BackpressureStrategy.LATEST)
            .toLiveData()
}