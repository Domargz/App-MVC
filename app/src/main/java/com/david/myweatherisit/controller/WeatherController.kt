package com.david.myweatherisit.controller

import androidx.fragment.app.Fragment
import com.david.myweatherisit.R
import com.david.myweatherisit.model.dto.CityResponse
import com.david.myweatherisit.view.details.DetailsFragment

class WeatherController(private val fragment: Fragment) {

    fun changeFragment() {
        val transaction = fragment.parentFragmentManager.beginTransaction()
        transaction.replace(R.id.containerFragment, DetailsFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }



}

