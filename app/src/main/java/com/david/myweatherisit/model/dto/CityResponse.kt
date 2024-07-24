package com.david.myweatherisit.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityResponse(
    val location: Location,
    val current: Current,
)

@Serializable
data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    @SerialName("tz_id")
    val tzId: String,
    @SerialName("localtime_epoch")
    val localtimeEpoch: Long,
    val localtime: String,
)

@Serializable
data class Current(
    @SerialName("temp_c")
    val tempC: Double,
    @SerialName("temp_f")
    val tempF: Double,
    val condition: Condition,
    val humidity: Long,
    val cloud: Long,
)
@Serializable
data class Condition(
    val icon: String,
)
