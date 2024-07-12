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
    val windCdir: String?,
    val rh: Long?,
    val pod: String?,
    val lon: Double?,
    val pres: Double?,
    val timezone: String?,
    @SerialName("ob_time")
    val obTime: String?,
    @SerialName("country_code")
    val countryCode: String?,
    val clouds: Long?,
    val vis: Long?,
    @SerialName("wind_spd")
    val windSpd: Double?,
    val gust: Double?,
    @SerialName("wind_cdir_full")
    val windCdirFull: String?,
    @SerialName("app_temp")
    val appTemp: Double?,
    @SerialName("state_code")
    val stateCode: String?,
    val ts: Long?,
    @SerialName("h_angle")
    val hAngle: Long?,
    val dewpt: Double?,
    val weather: Weather,
    val uv: Long?,
    val aqi: Long?,
    val station: String?,
    val sources: List<String?>,
    @SerialName("wind_dir")
    val windDir: Long?,
    @SerialName("elev_angle")
    val elevAngle: Double?,
    val datetime: String?,
    val precip: Long?,
    val ghi: Double?,
    val dni: Long?,
    @SerialName("solar_rad")
    val solarRad: Long?,
    @SerialName("city_name")
    val cityName: String?,
    val sunrise: String?,
    val sunset: String?,
    val temp: Double?,
    val lat: Double?,
    val slp: Double?,
)

@Serializable
data class Weather(
    val icon: String?,
    val code: Long?,
    val description: String?,
)
