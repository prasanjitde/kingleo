package com.pd.domain.utils

import com.pd.domain.entities.PlayerEntity

class TestDataGenerator {
    companion object {
        fun generatePlayerEntity(): PlayerEntity {
            return PlayerEntity(
                "Messi",
                32,
                "Argentina",
                "Barcelona"
            )
        }
    }
}