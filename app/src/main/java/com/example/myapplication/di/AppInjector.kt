package com.example.myapplication.di

import com.example.myapplication.data.AccountRepositoryImpl
import com.example.myapplication.data.DrinkRepositoryImpl
import com.example.myapplication.domain.interactor.GetAccountInfo
import com.example.myapplication.domain.interactor.GetDrink
import com.example.myapplication.domain.repository.AccountRepository
import com.example.myapplication.domain.repository.DrinkRepository
import com.example.myapplication.ui.MainActivity
import com.example.myapplication.ui.MainViewModel
import com.example.myapplication.ui.SecondVIewModel
import javax.xml.validation.TypeInfoProvider

/**
 * Created by kietnlt 02 Sep 2019.
 */
class AppInjector: Injector<MainActivity> {

    private val drinkRepositoryProvider: Provider<DrinkRepository> = DrinkRepositoryProvider()
    private val accountRepositoryProvider: Provider<AccountRepository> = AccountRepositoryProvider()
    private val getDrinkProvider: Provider<GetDrink> = GetDrinkProvider(
        drinkRepositoryProvider = drinkRepositoryProvider,
        accountRepositoryProvider = accountRepositoryProvider
    )
    private val getAccountInfoProvider: Provider<GetAccountInfo> = GetAccountInfoProvider(
        accountRepositoryProvider = accountRepositoryProvider
    )
    private val mainViewModelProvider: Provider<MainViewModel> = MainViewModelProvider(
        getDrinkProvider = getDrinkProvider,
        getAccountInfoProvider = getAccountInfoProvider
    )
    private val secondViewModelProvider: Provider<SecondVIewModel> = SecondViewModelProvider(
        gerDrinkProvider = getDrinkProvider
    )
    private val mainActivityInjectorProvider: Provider<Injector<MainActivity>> = MainActivityInjectorProvider(
        mainViewModelProvider = mainViewModelProvider,
        secondVIewModelProvider = secondViewModelProvider
    )

    override fun inject(instance: MainActivity) {
        val injector: Injector<MainActivity> = mainActivityInjectorProvider.get()
        injector.inject(instance)
    }

}

class GetAccountInfoProvider(
    private val accountRepositoryProvider: Provider<AccountRepository>
): Provider<GetAccountInfo> {
    override fun get(): GetAccountInfo {
        return GetAccountInfo(
            accountRepository = accountRepositoryProvider.get()
        )
    }

}

class MainActivityInjectorProvider(
    private val mainViewModelProvider: Provider<MainViewModel>,
    private val secondVIewModelProvider: Provider<SecondVIewModel>
): Provider<Injector<MainActivity>> {
    override fun get(): Injector<MainActivity> {
        val injector: Injector<MainActivity> = MainActivityInjector(
            mainViewModelProvider = mainViewModelProvider,
            secondViewModelProvider = secondVIewModelProvider
        )
        return injector
    }

}

class MainViewModelProvider(
    private val getDrinkProvider: Provider<GetDrink>,
    private val getAccountInfoProvider: Provider<GetAccountInfo>
): Provider<MainViewModel> {
    override fun get(): MainViewModel {
        val getDrink: GetDrink = getDrinkProvider.get()
        val getAccountInfo: GetAccountInfo = getAccountInfoProvider.get()
        return MainViewModel(
            getDrink = getDrink,
            getAccountInfo = getAccountInfo
        )
    }
}


class DrinkRepositoryProvider : Provider<DrinkRepository> {

    private var instance: DrinkRepository? = null


    override fun get(): DrinkRepository {
        if (instance == null) {
            instance = DrinkRepositoryImpl()
        }
        return instance!!
    }

}

class AccountRepositoryProvider : Provider<AccountRepository> {
    override fun get(): AccountRepository {
        return AccountRepositoryImpl()
    }
}


class GetDrinkProvider(
    private val drinkRepositoryProvider: Provider<DrinkRepository>,
    private val accountRepositoryProvider: Provider<AccountRepository>
): Provider<GetDrink> {
    override fun get(): GetDrink {
        val drinkRepository: DrinkRepository = drinkRepositoryProvider.get()
        return GetDrink(
            drinkRepository = drinkRepository,
            accountRepository = accountRepositoryProvider.get()
        )
    }
}

class SecondViewModelProvider(
    private val gerDrinkProvider: Provider<GetDrink>
): Provider<SecondVIewModel> {
    override fun get(): SecondVIewModel {
        return SecondVIewModel(
            getDrink = gerDrinkProvider.get()
        )
    }

}