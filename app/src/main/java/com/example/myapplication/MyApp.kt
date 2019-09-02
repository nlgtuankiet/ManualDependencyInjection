package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.AppInjector
import com.example.myapplication.di.Injector
import com.example.myapplication.ui.MainActivity

/**
 * Created by kietnlt 02 Sep 2019.
 */
class MyApp : Application(), Injector<MainActivity> {
    private lateinit var appInjector: AppInjector

    override fun inject(instance: MainActivity) {
        appInjector.inject(instance)
    }


    override fun onCreate() {
        super.onCreate()
        appInjector = AppInjector()
    }
}