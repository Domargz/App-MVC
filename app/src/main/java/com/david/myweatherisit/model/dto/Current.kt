package com.david.myweatherisit.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class Current(
    val cloud: Int,
    val condition: Condition,
    val humidity: Int,
    val temp_c: Double,
    val temp_f: Double
)