package com.david.myweatherisit.model.patterns.observer

interface Observable {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}