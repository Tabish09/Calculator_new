package com.example.calculator_jch.view.viewmodel.length_measurement

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator_jch.constants.MyCostants
import com.example.calculator_jch.utils.CustomToast
import com.example.calculator_jch.view.model.Measurements


class LengthMeasurementViewMmodel : ViewModel() {

    var calculatedOutPut = MutableLiveData<String>()


    fun doCalculation(
        value: String,
        from_measurement: Measurements,
        to_measurement: Measurements
    ): String {
        val input = value.toFloat()
        val from = from_measurement
        val to = to_measurement

        var outputRes = ""

        if (from.code.equals(MyCostants.KM) && to.code.equals(MyCostants.M)) {
            val output = (input * 1000).toBigDecimal()
            outputRes = output.toString()
        } else if (from.code.equals(MyCostants.KM) && to.code.equals(MyCostants.CM)) {
            val output = (input * 100000).toBigDecimal()
            outputRes = output.toString()
        } else if (from.code.equals(MyCostants.KM) && to.code.equals(MyCostants.MM)) {
            val output = (input * 1000000).toBigDecimal()
            outputRes = output.toString()
        } else if (from.code.equals(MyCostants.M) && to.code.equals(MyCostants.KM)) {
            val output = (input * 0.001).toBigDecimal()
            outputRes = output.toString()
        } else if (from.code.equals(MyCostants.M) && to.code.equals(MyCostants.CM)) {
            val output = (input * 100).toBigDecimal()
            outputRes = output.toString()
        } else if (from.code.equals(MyCostants.M) && to.code.equals(MyCostants.MM)) {
            val output = (input * 1000).toBigDecimal()
            outputRes = output.toString()
        } else if (from.code.equals(MyCostants.CM) && to.code.equals(MyCostants.KM)) {
            val output = (input * 0.001).toBigDecimal()
            outputRes = output.toString()
        } else if (from.code.equals(MyCostants.CM) && to.code.equals(MyCostants.M)) {
            val output = (input * 0.01).toBigDecimal()
            outputRes = output.toString()
        } else if (from.code.equals(MyCostants.CM) && to.code.equals(MyCostants.MM)) {
            val output = (input * 10).toBigDecimal()
            outputRes = output.toString()
        } else if (from.code.equals(MyCostants.MM) && to.code.equals(MyCostants.KM)) {
            val output = (input * 0.000001).toBigDecimal()
            outputRes = output.toString()
        } else if (from.code.equals(MyCostants.MM) && to.code.equals(MyCostants.M)) {
            val output = (input * 0.001).toBigDecimal()
            outputRes = output.toString()
        } else if (from.code.equals(MyCostants.MM) && to.code.equals(MyCostants.CM)) {
            val output = (input * 0.1).toBigDecimal()
            outputRes = output.toString()
        } else if (to.code.equals(from.code)) {
            outputRes = input.toString()
        } else {
            CustomToast.showToast("Something went wrong!")
        }
        calculatedOutPut.postValue(outputRes)
        return outputRes
    }

}