package com.david.myweatherisit

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.preference.PreferenceManager
import com.david.myweatherisit.model.LocationManagement
import com.david.myweatherisit.model.WeatherData
import com.david.myweatherisit.model.patterns.observer.Observable
import com.david.myweatherisit.model.patterns.observer.Observer
import com.david.myweatherisit.view.FavoriteFragment
import com.david.myweatherisit.view.SettingsFragments
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), Observable {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var cityDefault: String
    private lateinit var locationManager:LocationManager
    private lateinit var locationManagement: LocationManagement
    private var observers = mutableListOf<Observer>()



    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("MissingPermission")
    val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                locationManagement = LocationManagement(locationManager)

                locationManagement.requestLocation()

                val deferredWeatherData = CoroutineScope(Dispatchers.IO).async {
                    WeatherData.requestByCoordinates(locationManagement.latitude!!, locationManagement.longitude!!)
                }

                CoroutineScope(Dispatchers.Main).launch {
                    deferredWeatherData.await()
                    notifyObservers()
                }

            }else{
                val deferredWeatherData = CoroutineScope(Dispatchers.IO).async {
                    WeatherData.requestByName(cityDefault)
                }

                CoroutineScope(Dispatchers.Main).launch {
                    deferredWeatherData.await()
                    notifyObservers()
                }

            }
        }




    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        cityDefault = sharedPreferences.getString("City", "London") ?: "London"
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        val homeFragment = HomeFragment()
        addObserver(homeFragment)


        setContentView(R.layout.activity_main)

        openFragment(homeFragment)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.home

        when {
            ContextCompat.checkSelfPermission(
                this,
                ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
                locationManagement = LocationManagement(locationManager)

                locationManagement.requestLocation()

                val deferredWeatherData = CoroutineScope(Dispatchers.IO).async {
                    WeatherData.requestByCoordinates(locationManagement.latitude!!, locationManagement.longitude!!)
                }

                CoroutineScope(Dispatchers.Main).launch {
                    deferredWeatherData.await()
                    notifyObservers()
                }
            }
//            ActivityCompat.shouldShowRequestPermissionRationale(
//                this, ACCESS_COARSE_LOCATION) -> {
//                // In an educational UI, explain to the user why your app requires this
//                // permission for a specific feature to behave as expected, and what
//                // features are disabled if it's declined. In this UI, include a
//                // "cancel" or "no thanks" button that lets the user continue
//                // using your app without granting the permission.
//
//            }
            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                requestPermissionLauncher.launch(
                    ACCESS_COARSE_LOCATION)
            }
        }



        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    openFragment(homeFragment)
                    true
                }

                R.id.favorites -> {
                    openFragment(FavoriteFragment())
                    true
                }

                R.id.settings -> {
                    openFragment(SettingsFragments())
                    true
                }

                else -> {
                    false
                }
            }
        }


    }

    override fun notifyObservers() {
        for( ob in observers){
            ob.update()
        }
    }

    override fun addObserver(observer: Observer) {
        this.observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        this.observers.remove(observer)
    }

    private fun openFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction =
            getSupportFragmentManager().beginTransaction()
        fragmentTransaction.replace(R.id.containerFragment, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


}