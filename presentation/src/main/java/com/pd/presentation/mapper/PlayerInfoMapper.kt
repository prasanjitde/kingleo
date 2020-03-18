package com.pd.presentation.mapper

import com.pd.domain.entities.PlayerEntity
import com.pd.presentation.model.PlayerInfo
import javax.inject.Inject

class PlayerInfoMapper @Inject constructor(): Mapper<PlayerEntity, PlayerInfo> {
    override fun from(e: PlayerEntity): PlayerInfo {
        return PlayerInfo(
            playerName = e.playerName,
            playerAge = e.playerAge,
            playerCountry = e.playerCountry,
            playerClub = e.playerClub
        )
    }

    override fun to(t: PlayerInfo): PlayerEntity {
        return PlayerEntity(
            playerName = t.playerName,
            playerAge = t.playerAge,
            playerCountry = t.playerCountry,
            playerClub = t.playerClub
        )
    }

}