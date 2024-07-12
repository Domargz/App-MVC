package com.david.myweatherisit.model.apiclient

import com.david.myweatherisit.BuildConfig
import com.david.myweatherisit.model.dto.CityResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class KtorClient {
    private val api:HttpClient = HttpClient(Android){
        install(ContentNegotiation){
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })

        }
    }

    private val URL_BASE = "https://api.weatherbit.io/v2.0/current"
    private val API_KEY = BuildConfig.API_KEY

    suspend fun request(city: String): CityResponse{
        return api.get(URL_BASE){
            url{
                parameters.append("key", API_KEY)
                parameters.append("city", city)
            }
        }.body()
    }

}