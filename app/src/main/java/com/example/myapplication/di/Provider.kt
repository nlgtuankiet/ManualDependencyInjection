package com.example.myapplication.di

/**
 * Created by kietnlt 02 Sep 2019.
 */
interface Provider<T> {
    fun get(): T
}