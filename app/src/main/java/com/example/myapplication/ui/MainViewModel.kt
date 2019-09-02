package com.example.myapplication.ui

import com.example.myapplication.domain.entity.Drink
import com.example.myapplication.domain.interactor.GetAccountInfo
import com.example.myapplication.domain.interactor.GetDrink

/**
 * Created by kietnlt 02 Sep 2019.
 */
class MainViewModel(
    private val getDrink: GetDrink,
    private val getAccountInfo: GetAccountInfo
) {
    var name: String = ""
    var price: String = ""

    init {
        val drink: Drink = getDrink.run("123")
        name = drink.name
        price = drink.price.toString()
        getAccountInfo.run()
    }
}