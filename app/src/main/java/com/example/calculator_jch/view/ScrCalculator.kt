package com.example.calculator_jch.view

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.calculator_jch.R
import com.example.calculator_jch.databinding.ActivityScrCalculatorBinding
import com.whirlpool.prodigio_app.utils.CustomIntent

class ScrCalculator : AppCompatActivity() {

    val TAG: String = ScrCalculator::class.java.name
    lateinit var binding: ActivityScrCalculatorBinding

    private var canAddOperation = false
    private var canAddDecimal = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scr_calculator)
    }

    fun numberAction(view: View) {
        if (view is Button) {
            if (view.text == ".") {
                if (canAddDecimal)
                    binding.workingsTV.append(view.text)

                canAddDecimal = false
            } else
                binding.workingsTV.append(view.text)

            canAddOperation = true
        }
    }

    fun operationAction(view: View) {
        if (view is Button && canAddOperation) {
            Log.d(TAG, "operationAction: ${view.text}")
            binding.workingsTV.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }

    fun allClearAction(view: View) {
        binding.workingsTV.text = ""
        binding.resultsTV.text = ""
    }

    fun backSpaceAction(view: View) {
        val length = binding.workingsTV.length()
        if (length > 0)
            binding.workingsTV.text = binding.workingsTV.text.subSequence(0, length - 1)
    }

    fun equalsAction(view: View) {
        binding.resultsTV.text = calculateResults()
    }

    private fun calculateResults(): String {
        val digitsOperators = digitsOperators()
        if (digitsOperators.isEmpty()) return ""

        val timesDivision = timesDivisionCalculate(digitsOperators)
        Log.d(TAG, "calculateResults: timesDivision $timesDivision")
        if (timesDivision.isEmpty()) return ""
        if (timesDivision.get(0).equals("Can't divide by zero")) return "Can't divide by zero"

        val result = addSubtractCalculate(timesDivision)
        return result.toString()
    }

    private fun addSubtractCalculate(passedList: MutableList<Any>): Float {
        var result = passedList[0] as Float

        for (i in passedList.indices) {
            if (passedList[i] is Char && i != passedList.lastIndex) {
                val operator = passedList[i]
                val nextDigit = passedList[i + 1] as Float
                if (operator == '+')
                    result += nextDigit
                if (operator == '-')
                    result -= nextDigit
            }
        }

        return result
    }

    private fun timesDivisionCalculate(passedList: MutableList<Any>): MutableList<Any> {
        var list = passedList
        Log.d(TAG, "timesDivisionCalculate: before ${list}")
        while (list.contains('x') || list.contains('/')) {
            list = calcTimesDiv(list)
        }

        Log.d(TAG, "timesDivisionCalculate: after $list")
        return list
    }

    private fun calcTimesDiv(passedList: MutableList<Any>): MutableList<Any> {
        val newList = mutableListOf<Any>()
        var restartIndex = passedList.size

        for (i in passedList.indices) {
            if (passedList[i] is Char && i != passedList.lastIndex && i < restartIndex) {
                val operator = passedList[i]
                val prevDigit = passedList[i - 1] as Float
                val nextDigit = passedList[i + 1] as Float
                when (operator) {
                    'x' -> {
                        newList.add(prevDigit * nextDigit)
                        restartIndex = i + 1
                    }
                    '/' -> {
                        Log.d(TAG, "calcTimesDiv: prevDigit $prevDigit nextDigit $nextDigit")

                        if (nextDigit == 0.0f) {
                            Log.d(TAG, "calcTimesDiv: inside if")
                            newList.add("Can't divide by zero")
                            return newList
                        } else {
                            Log.d(TAG, "calcTimesDiv: inside else")
                            newList.add(prevDigit / nextDigit)
                        }
                        restartIndex = i + 1
                    }
                    else -> {
                        newList.add(prevDigit)
                        newList.add(operator)
                    }
                }
            }

            if (i > restartIndex)
                newList.add(passedList[i])
        }

        return newList
    }

    private fun digitsOperators(): MutableList<Any> {
        val list = mutableListOf<Any>()
        var currentDigit = ""
        for (character in binding.workingsTV.text) {
            if (character.isDigit() || character == '.')
                currentDigit += character
            else {
                list.add(currentDigit.toFloat())
                currentDigit = ""
                list.add(character)
            }
        }

        if (currentDigit != "")
            list.add(currentDigit.toFloat())

        return list
    }

    fun openLenngthMeasurementScreen(view: View) {
        CustomIntent.startActivity(this, ScrLengthMeasurement::class.java, false)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            window.decorView.windowInsetsController!!.hide(WindowInsets.Type.statusBars())
        } else {
            window.decorView.windowInsetsController!!.show(WindowInsets.Type.statusBars())
        }
    }
}