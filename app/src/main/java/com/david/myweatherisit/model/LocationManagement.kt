package com.david.myweatherisit.model

import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.GPS_PROVIDER
import android.location.LocationManager.NETWORK_PROVIDER

class LocationManagement(private val locationManager: LocationManager) {

    val hasGps = locationManager.isProviderEnabled(GPS_PROVIDER)
    val hasNetwork = locationManager.isProviderEnabled(NETWORK_PROVIDER)


    private var locationByGps: Location? = null
    private var locationByNetwork: Location? = null

    var latitude: Double? = null
    var longitude: Double? = null


    val gpsLocationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: android.location.Location) {
            locationByGps = location
        }

    }

    val networkLocationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: android.location.Location) {
            locationByNetwork = location
        }

    }

    @SuppressLint("MissingPermission")
    fun requestLocation() {
        locationByGps = locationManager.getLastKnownLocation(GPS_PROVIDER)
        locationByNetwork = locationManager.getLastKnownLocation(NETWORK_PROVIDER)


        if (hasGps) {
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                5000,
                0F,
                gpsLocationListener
            )
        }

        if (hasNetwork) {
            locationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                5000,
                0F,
                networkLocationListener
            )
        }

        longitude = locationByGps?.longitude ?: locationByNetwork?.longitude
        latitude = locationByGps?.latitude ?: locationByNetwork?.latitude
    }


}