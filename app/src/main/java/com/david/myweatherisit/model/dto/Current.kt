package com.david.myweatherisit.model.dto

data class Current(
    val cloud: Int,
    val condition: Condition,
    val humidity: Int,
    val temp_c: Double,
    val temp_f: Double
)