package com.example.myapplication.domain.repository

import com.example.myapplication.domain.entity.Drink

/**
 * Created by kietnlt 02 Sep 2019.
 */
interface DrinkRepository {
    fun getDrink(drinkId: String): Drink
}