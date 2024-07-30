package com.david.myweatherisit.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class Forecastday(
    val day: Day
)