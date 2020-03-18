package com.pd.data.mapper

import com.pd.data.models.PlayerData
import com.pd.domain.entities.PlayerEntity
import javax.inject.Inject

class PlayerDataMapper @Inject constructor(): Mapper<PlayerEntity, PlayerData> {
    override fun from(e: PlayerData): PlayerEntity {
        return PlayerEntity(
            playerName = e.playerName,
            playerAge = e.playerAge,
            playerCountry = e.playerCountry,
            playerClub = e.playerClub
        )
    }

    override fun to(t: PlayerEntity): PlayerData {
        return PlayerData(
            playerName = t.playerName,
            playerAge = t.playerAge,
            playerCountry = t.playerCountry,
            playerClub = t.playerClub
        )
    }
}