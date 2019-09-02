package com.example.myapplication.domain.interactor

import com.example.myapplication.domain.repository.AccountRepository

/**
 * Created by kietnlt 02 Sep 2019.
 */
class GetAccountInfo(
    private val accountRepository: AccountRepository
) {
    fun run() {
        accountRepository.make()
    }
}