package com.whirlpool.prodigio_app.utils

import android.annotation.SuppressLint
import android.util.Log
import java.lang.Exception
import java.lang.NumberFormatException
import java.text.DecimalFormat

class DecimalConvertor {

    companion object {
        @SuppressLint("DefaultLocale")
        fun BuildDecimal(data: String): String? {
            val d: Double
            val d2: Double
            var converted_value: String? = null
            try {
                if (data != "N/A" && data != "NA") {
                    d = data.toDouble()
                    converted_value = String.format("%.2f", d)
                    if (converted_value.contains(",")) {
                        converted_value = converted_value.replace(",".toRegex(), ".")
                    }
                    d2 = converted_value.toDouble()
                    converted_value = if (d2 - d2.toInt() != 0.0) {
                        Log.d("DecimalConverter", "BuildDecimal: decimal value is there")
                        d2.toString()
                    } else {
                        Log.d("DecimalConverter", "BuildDecimal: decimal value is not there")
                        String.format("%.2f", d2)
                    }
                } else {
                    converted_value = data
                }
                Log.d("DecimalConverter", "" + converted_value)
            } catch (e: NumberFormatException) {
                e.printStackTrace()
                Log.d("TAG", "BuildDecimal: Exception : " + e.message)
            }
            if (converted_value != null) {
                if (converted_value.contains(",")) {
                    converted_value = converted_value.replace(",".toRegex(), ".")
                }
            }
            return converted_value
        }

        fun BuildDecimalWith1(data: String?): String? {
            val d: Double
            val d2: Double
            var converted_value: String? = null
            try {
                if (data != null) {
                    if (data != "N/A" && data != "NA") {
                        d = data.toDouble()
                        converted_value = String.format("%.1f", d)
                        d2 = converted_value.toDouble()
                        converted_value = if (d2 - d2.toInt() != 0.0) {
                            Log.d("DecimalConverter", "BuildDecimal: decimal value is there")
                            d2.toString()
                        } else {
                            Log.d("DecimalConverter", "BuildDecimal: decimal value is not there")
                            String.format("%.1f", d2)
                        }
                    } else {
                        converted_value = data
                    }
                    Log.d("DecimalConverter", "" + converted_value)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("TAG", "BuildDecimalWith1: " + e.message)
            }
            if (converted_value != null) {
                if (converted_value.contains(",")) {
                    converted_value = converted_value.replace(",".toRegex(), ".")
                }
            }
            return converted_value
        }

        fun BuildDecimalWith2(data: String?): String? {
            val d: Double
            val d2: Double
            var converted_value: String? = null
            try {
                if (data != null) {
                    if (data != "N/A" && data != "NA") {
                        d = data.toDouble()
                        converted_value = String.format("%.2f", d)
                        d2 = converted_value.toDouble()
                        Log.d("DecimalConverter", "BuildDecimal: decimal value is not there")
                        converted_value = String.format("%.2f", d2)
                    } else {
                        converted_value = data
                    }
                    Log.d("DecimalConverter", "" + converted_value)
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
                Log.d("TAG", "BuildDecimalWith2: Exception " + e.message)
            }
            if (converted_value != null) {
                if (converted_value.contains(",")) {
                    converted_value = converted_value.replace(",".toRegex(), ".")
                }
            }
            return converted_value
        }

        fun BuildDecimal2(data: String?): String? {
            val d: Double
            val d2: Double
            var converted_value: String? = null
            if (data != null) {
                if (data != "N/A" && data != "NA") {
                    d = data.toDouble()
                    converted_value = String.format("%.2f", d)
                    if (converted_value.contains(",")) {
                        converted_value = converted_value.replace(",".toRegex(), ".")
                    }
                    d2 = converted_value.toDouble()
                    val format = DecimalFormat("0.##")
                    converted_value = format.format(d2)
                } else {
                    converted_value = data
                }
                Log.d("DecimalConverter", "" + converted_value)
            }
            if (converted_value != null) {
                if (converted_value.contains(",")) {
                    converted_value = converted_value.replace(",".toRegex(), ".")
                }
            }
            return converted_value
        }


        fun ReplaceCommaWithDecimal(`val`: String?): String? {
            var `val` = `val`
            if (`val` != null) {
                if (`val`.contains(",")) {
                    `val` = `val`.replace(",".toRegex(), ".")
                }
            }
            return `val`
        }
    }

}