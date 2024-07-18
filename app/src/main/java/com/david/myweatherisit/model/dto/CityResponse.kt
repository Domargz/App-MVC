package com.david.myweatherisit.model.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CityResponse (
    val data: Array<Data>
)
@Serializable
data class Data(
    @SerialName("wind_cdir")
    val windCdir: String? = null,
    val rh: Double? = null,
    val pod: String? = null,
    val lon: Double? = null,
    val pres: Double? = null,
    val timezone: String? = null,
    @SerialName("ob_time")
    val obTime: String? = null,
    @SerialName("country_code")
    val countryCode: String? = null,
    val clouds: Double? = null,
    val vis: Double? = null,
    @SerialName("wind_spd")
    val windSpd: Double? = null,
    val gust: Double? = null,
    @SerialName("wind_cdir_full")
    val windCdirFull: String? = null,
    @SerialName("app_temp")
    val appTemp: Double? = null,
    @SerialName("state_code")
    val stateCode: String? = null,
    val ts: Double? = null,
    @SerialName("h_angle")
    val hAngle: Double? = null,
    val dewpt: Double? = null,
    val weather: Weather,
    val uv: Double? = null,
    val aqi: Double? = null,
    val station: String? = null ,
    val sources: List<String>? = null,
    @SerialName("wind_dir")
    val windDir: Double? = null,
    @SerialName("elev_angle")
    val elevAngle: Double? = null,
    val datetime: String? = null,
    val precip: Double? = null,
    val ghi: Double? = null,
    val dni: Double? = null,
    @SerialName("solar_rad")
    val solarRad: Double? = null,
    @SerialName("city_name")
    val cityName: String,
    val sunrise: String? = null,
    val sunset: String? = null,
    val temp: Double? = null,
    val lat: Double? = null,
    val slp: Double? = null,
)

@Serializable
data class Weather(
    val icon: String? = null,
    val code: Double? = null,
    val description: String? = null,
)
