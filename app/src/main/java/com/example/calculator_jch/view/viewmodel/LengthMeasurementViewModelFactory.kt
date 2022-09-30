package com.example.calculator_jch.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LengthMeasurementViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LengthMeasurementViewMmodel::class.java)){
                LengthMeasurementViewMmodel() as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}