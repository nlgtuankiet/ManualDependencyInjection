package com.example.myapplication.domain.entity

/**
 * Created by kietnlt 02 Sep 2019.
 */

/**
 * {
"id":"4"
"status": "in_stock" "out_of_stock" "error404"
"typeneW": "fruit" "soft_drink" "hard_drink"
"name": "Cafe ep dau"
"price": 15000
}

{
"id":String
"status": String with bat ngo
"typeneW": String
"name": String
"price": Number
}
 */

class Drink(
    val id: Long,
    val name: String,
    val type: DrinkType,
    val status: DrinkStatus,
    val price: Long
)