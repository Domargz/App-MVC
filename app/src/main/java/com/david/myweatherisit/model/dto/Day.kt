package com.david.myweatherisit.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class Day(
    val condition: ConditionX,
    val maxtemp_c: Double,
    val maxtemp_f: Double
)