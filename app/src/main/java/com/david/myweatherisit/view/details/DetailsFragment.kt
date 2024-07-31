package com.david.myweatherisit.view.details

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.david.myweatherisit.R
import com.david.myweatherisit.model.WeatherData
import com.david.myweatherisit.model.adapter.RecyclerAdapter
import com.david.myweatherisit.model.utils.getNextDays
import com.david.myweatherisit.view.SettingsFragments
import com.david.myweatherisit.view.WeatherView

class DetailsFragment() : Fragment() {

    private val setting = SettingsFragments()


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val forecastDay = WeatherData.city?.forecast?.forecastday
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        val weatherView = WeatherView(view)
        val nextDays = getNextDays(WeatherData.city?.location?.localtime!!)

        weatherView.fillDetailsFragment()
        val recylcerAdapter = RecyclerAdapter(forecastDay!!, nextDays)
        val recyclerView = view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.idRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = recylcerAdapter
        setting.changeTemperature(view.findViewById(R.id.idTemperatureDetails))


        return view
    }

}