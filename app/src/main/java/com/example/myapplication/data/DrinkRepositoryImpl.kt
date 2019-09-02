package com.example.myapplication.data

import com.example.myapplication.domain.entity.Drink
import com.example.myapplication.domain.entity.DrinkStatus
import com.example.myapplication.domain.entity.DrinkType
import com.example.myapplication.domain.repository.DrinkRepository

/**
 * Created by kietnlt 02 Sep 2019.
 */
class DrinkRepositoryImpl : DrinkRepository {
    override fun getDrink(drinkId: String): Drink {
        /**
         * class Drink(
        val id: Long,
        val name: String,
        val type: DrinkType,
        val status: DrinkStatus,
        val price: Long
        )
         */
        return Drink(
            id = 123,
            name = "Dau",
            type = DrinkType.Fruit,
            status = DrinkStatus.InStock,
            price = 10000
        )
    }
}