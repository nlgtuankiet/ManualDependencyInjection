package com.example.myapplication.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.di.Injector

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var secondVIewModel: SecondVIewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val app = applicationContext
        val mainActivityInjector: Injector<MainActivity> = app as Injector<MainActivity>
        mainActivityInjector.inject(this)
        findViewById<TextView>(R.id.name_text_view).text = viewModel.name
        findViewById<TextView>(R.id.price_text_view).text = viewModel.price

    }
}
