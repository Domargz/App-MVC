package com.david.myweatherisit.view

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.preference.EditTextPreference
import androidx.preference.PreferenceFragmentCompat
import com.david.myweatherisit.R
import com.david.myweatherisit.model.WeatherData.city

class SettingsFragments : PreferenceFragmentCompat() {


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference, rootKey)

    }

    fun changeTemperature(textView: TextView){
        findPreference<EditTextPreference>("Temperature")?.setOnPreferenceChangeListener { _, newValue ->

            textView.text = if (newValue == "C") city.current.tempC.toString() else city.current.tempF.toString()
            Toast.makeText(context, "Temperature changed", Toast.LENGTH_SHORT).show()
            true
        }
    }

}