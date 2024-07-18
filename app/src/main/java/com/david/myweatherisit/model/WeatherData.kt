package com.david.myweatherisit.model

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.david.myweatherisit.R
import com.david.myweatherisit.model.apiclient.KtorClient
import com.david.myweatherisit.model.dto.CityResponse
import com.david.myweatherisit.view.details.DetailsFragment

class WeatherData {
    val api: KtorClient = KtorClient()
    suspend fun request(cityQuery: String): CityResponse{
        return api.request(cityQuery)
    }


}