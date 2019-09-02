package com.example.myapplication.domain.interactor

import com.example.myapplication.domain.entity.Drink
import com.example.myapplication.domain.repository.AccountRepository
import com.example.myapplication.domain.repository.DrinkRepository

/**
 * Created by kietnlt 02 Sep 2019.
 */
class GetDrink(
    private val drinkRepository: DrinkRepository,
    private val accountRepository: AccountRepository
) {

    fun run(drinkId: String): Drink {
        accountRepository.make()
        if (drinkId.isBlank())
            throw IllegalArgumentException("Drink id must not be blank")
        val drink: Drink = drinkRepository.getDrink(drinkId = drinkId)
        return drink
    }
}