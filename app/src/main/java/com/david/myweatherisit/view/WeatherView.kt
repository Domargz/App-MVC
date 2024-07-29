package com.david.myweatherisit.view

import android.view.View
import android.widget.TextView
import com.david.myweatherisit.R
import com.david.myweatherisit.model.WeatherData.city


class WeatherView(val view: View) {



    fun fillDetailsFragment() {
        //val temperature = preference.getString("temperature", "M")
        val cityView = view.findViewById<TextView>(R.id.idCityNameDetails)
        val temperatureView = view.findViewById<TextView>(R.id.idTemperatureDetails)
        val humidityView = view.findViewById<TextView>(R.id.idHumedity)
        val cloudsView = view.findViewById<TextView>(R.id.idClouds)
        //val iconView = view?.findViewById<>(R.id.idIcon)

        cityView.text = city.location.name
        temperatureView.text = city.current.tempC.toString()
           // if (temperature == "M") city.current.tempC.toString() else city.current.tempF.toString()
        humidityView.text = city.current.humidity.toString()
        cloudsView.text = city.current.cloud.toString()
        //iconView?.text = paramIcon

    }




}