package com.example.calculator_jch.view.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import com.example.calculator_jch.constants.MyCostants.CENTIMETER
import com.example.calculator_jch.constants.MyCostants.KILOMETER
import com.example.calculator_jch.constants.MyCostants.KM
import com.example.calculator_jch.constants.MyCostants.M
import com.example.calculator_jch.constants.MyCostants.METER
import com.example.calculator_jch.constants.MyCostants.MILIMETER
import com.example.calculator_jch.view.model.Measurements
import com.example.calculator_jch.view.viewmodel.length_measurement.LengthMeasurementViewMmodel
import junit.framework.TestCase
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.BeforeClass


class LengthMeasurementViewMmodelTest : TestCase() {

    private val TAG = "LengthMeasurementViewMm"

    @Before
    fun startTestCases() {
        Log.d(TAG, "unit testing stating")
    }

    @SuppressLint("CheckResult")
    @Test
    fun testKilometerToMeter() {
        val input = 5
        val from_measurerment = Measurements(KILOMETER, KM)
        val to_measurement = Measurements(METER, M)

        val result = LengthMeasurementViewMmodel().doCalculation(
            input.toString(),
            from_measurerment,
            to_measurement
        )
        Log.d(TAG, "testKilometerToMeter : ${result}")
        assertThat(result).isEqualTo("5000.0")
    }

    @SuppressLint("CheckResult")
    @Test
    fun testCentimeterToMilimeter() {
        val input = 1
        val from_measurerment = Measurements(CENTIMETER, KM)
        val to_measurement = Measurements(MILIMETER, M)

        val result = LengthMeasurementViewMmodel().doCalculation(
            input.toString(),
            from_measurerment,
            to_measurement
        )
        Log.d(TAG, "testCentimeterToMilimeter : ${result}")
        assertThat(result).isEqualTo("1000.0")
    }

}