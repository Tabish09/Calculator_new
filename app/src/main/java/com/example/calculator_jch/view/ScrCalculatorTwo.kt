package com.example.calculator_jch.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.calculator_jch.R
import com.example.calculator_jch.databinding.ActivityScrCalculatorBinding
import com.example.calculator_jch.databinding.ActivityScrCalculatorTwoBinding
import java.lang.NumberFormatException

class ScrCalculatorTwo : AppCompatActivity() {
    val TAG: String = ScrCalculator::class.java.name
    lateinit var binding: ActivityScrCalculatorTwoBinding

    var signs:ArrayList<String> = ArrayList<String>()
    var signs2 = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scr_calculator_two)

        binding.buttonClear.setOnClickListener {
            binding.input.text = ""
            binding.output.text = ""
        }


        binding.buttonCroxx.setOnClickListener {
            val removedLast = binding.input.text.toString().dropLast(1)
            binding.input.text = removedLast
        }

        binding.button0.setOnClickListener {
            userInput("0")
        }
        binding.button1.setOnClickListener {
            userInput("1")
        }
        binding.button2.setOnClickListener {
            userInput("2")
        }
        binding.button3.setOnClickListener {
            userInput("3")
        }
        binding.button4.setOnClickListener {
            userInput("4")
        }
        binding.button5.setOnClickListener {
            userInput("5")
        }
        binding.button6.setOnClickListener {
            userInput("6")
        }
        binding.button7.setOnClickListener {
            userInput("7")
        }
        binding.button8.setOnClickListener {
            userInput("8")
        }
        binding.button9.setOnClickListener {
            userInput("9")
        }
        binding.buttonDot.setOnClickListener {
            userInput(".")
        }

        binding.buttonDivision.setOnClickListener {
            if (!signs.contains("/")) {
                signs.add("/")
            }
            signs2 = "/"
            userInput("/") // ALT + 0247
        }
        binding.buttonMultiply.setOnClickListener {
            if (!signs.contains("*")) {
                signs.add("*")
            }
            signs2 = "*"
            userInput("*") // ALT + 0215
        }
        binding.buttonSubtraction.setOnClickListener {
            if (!signs.contains("-")) {
                signs.add("-")
            }
            signs2 = "-"
            userInput("-")
        }
        binding.buttonAddition.setOnClickListener {
            if (!signs.contains("+")) {
                signs.add("+")
            }
            signs2 = "+"
            userInput("+")
        }
        binding.buttonEquals.setOnClickListener {
            userInput("=")
        }
    }



    fun userInput(input: String) {
        if (input != "=") {
            binding.input.text = binding.input.text.toString() + input
        } else {
            Log.d(TAG, "userInput: output : ${binding.input.text}")
            var splitted = binding.input.text?.split(signs2)
            Log.d(TAG, "userInput: splitted : $splitted")
            try {
                val num1 = splitted?.get(0)?.toInt()
                val num2 = splitted?.get(1)?.toInt()
                Log.d(TAG, "userInput: num1 $num1  num2 $num2 sign $signs")
                var total = 0
                when (signs2) {
                    "+" -> total = num1!! + num2!!
                    "-" -> total = num1!! - num2!!
                    "*" -> total = num1!! * num2!!
                    "/" -> total = num1!! / num2!!
                }
                Log.d(TAG, "userInput: result : $total")
                binding.output.text = total.toString()
            }catch (e: NumberFormatException){
                e.printStackTrace()
                Log.d(TAG, "userInput: exceptiono : "+e.message)
            }
        }
    }

}