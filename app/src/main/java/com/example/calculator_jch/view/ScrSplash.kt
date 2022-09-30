package com.example.calculator_jch.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.calculator_jch.R
import com.whirlpool.prodigio_app.utils.CustomIntent

class ScrSplash : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        startNext()
    }

    fun startNext() {
        Handler(Looper.getMainLooper()).postDelayed({
            CustomIntent.startActivity(this, ScrCalculator::class.java, false)
        }, 2000)
    }
}