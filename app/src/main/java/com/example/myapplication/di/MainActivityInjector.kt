package com.example.myapplication.di

import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.ui.MainActivity
import com.example.myapplication.ui.MainViewModel
import com.example.myapplication.ui.SecondVIewModel

/**
 * Created by kietnlt 02 Sep 2019.
 */
class MainActivityInjector(
    private val mainViewModelProvider: Provider<MainViewModel>,
    private val secondViewModelProvider: Provider<SecondVIewModel>
) : Injector<MainActivity> {
    override fun inject(instance: MainActivity) {
        val viewModel: MainViewModel = mainViewModelProvider.get()
        instance.viewModel = viewModel
        instance.secondVIewModel = secondViewModelProvider.get()
    }
}