package com.david.myweatherisit.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.david.myweatherisit.R
import com.david.myweatherisit.view.SettingsFragments
import com.david.myweatherisit.view.WeatherView

class DetailsFragment() : Fragment() {

    private val setting = SettingsFragments()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        val weatherView = WeatherView(view)

        weatherView.fillDetailsFragment()
        setting.changeTemperature(view.findViewById(R.id.idTemperatureDetails))


        return view
    }

}