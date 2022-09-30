package com.example.calculator_jch.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import com.example.calculator_jch.AppApplication
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

class CustomToast {

    companion object {
        fun showToast(message: String) {
            Toast.makeText(AppApplication.getInstance(), message, Toast.LENGTH_SHORT).show()
        }

        fun showLongToast(message: String) {
            Toast.makeText(AppApplication.getInstance(), message, Toast.LENGTH_LONG).show()
        }

    }
}


object Extensions{
    fun View.visible(){
        visibility = View.VISIBLE
    }
    fun View.invisible(){
        visibility = View.INVISIBLE
    }
    fun View.gone(){
        visibility = View.GONE
    }

    fun View.showSnackbar(text:String){
        Snackbar.make(this,text, Snackbar.LENGTH_LONG).show()
    }

    fun Context.showToast(text:String){
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
    }

    fun Activity.setTextOnTextView(@IdRes id:Int, text:String){
        findViewById<TextView>(id).text = text
    }

    fun String.isValidEmail(): Boolean = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    fun String.isValidPassword():Boolean = this.isNotEmpty() && this.length>8

    fun Context.startActivityExtension(toClass: Class<*>, extras: Bundle?) {
        val intent = Intent(this, toClass)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        if (extras != null) {
            intent.putExtras(extras)
        }
        startActivity(intent)
    }

    fun String.toDate(dateFormat: String = "yyyy-MM-dd HH:mm:ss", timeZone: TimeZone = TimeZone.getTimeZone("UTC")): Date {
        val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
        parser.timeZone = timeZone
        return parser.parse(this)
    }

    fun Date.formatTo(dateFormat: String, timeZone: TimeZone = TimeZone.getDefault()): String {
        val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
        formatter.timeZone = timeZone
        return formatter.format(this)
    }


}