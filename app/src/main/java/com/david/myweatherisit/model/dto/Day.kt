package com.david.myweatherisit.model.dto

data class Day(
    val condition: ConditionX,
    val maxtemp_c: Double,
    val maxtemp_f: Double
)