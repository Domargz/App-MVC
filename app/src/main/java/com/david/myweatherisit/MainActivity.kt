package com.david.myweatherisit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.david.myweatherisit.view.FavoriteFragment
import com.david.myweatherisit.view.SettingsFragments
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.home

        openFragment(HomeFragment())

        bottomNav.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home -> {
                    openFragment(HomeFragment())
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

    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = getSupportFragmentManager().beginTransaction()
        fragmentTransaction.replace(R.id.constraintFragment, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}