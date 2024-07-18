package com.david.myweatherisit.model

import com.david.myweatherisit.model.apiclient.KtorClient
import com.david.myweatherisit.model.dto.CityResponse

class WeatherData {
    val api: KtorClient = KtorClient()
    suspend fun request(cityQuery: String): CityResponse{
        return api.request(cityQuery)
    }


}