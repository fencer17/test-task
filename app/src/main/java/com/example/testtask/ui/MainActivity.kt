package com.example.testtask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.testtask.R
import com.example.testtask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initNavigation()
    }

    private fun initNavigation() {
        val navController =
            (supportFragmentManager.findFragmentById(R.id.mainHostFragment) as NavHostFragment).navController
        navController.setGraph(R.navigation.nav_main)

    }
}