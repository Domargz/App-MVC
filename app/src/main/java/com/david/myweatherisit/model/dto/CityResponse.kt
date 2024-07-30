package com.david.myweatherisit.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class CityResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)