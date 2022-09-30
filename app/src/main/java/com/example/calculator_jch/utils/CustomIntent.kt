package com.whirlpool.prodigio_app.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class CustomIntent {

    companion object {

        fun startActivity(activity: Activity?, name: Class<*>?, isFinish: Boolean, bundle : Bundle) {
            if (activity == null) {
                return
            }
            activity.runOnUiThread(Runnable {
                val intent = Intent(activity, name)
                intent.putExtras(bundle)
                if (isFinish) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                }
                activity.startActivity(intent)
            })
        }


        fun startActivity(activity: Activity?, name: Class<*>?, isFinish: Boolean) {
            if (activity == null) {
                return
            }
            activity.runOnUiThread(Runnable {
                val intent = Intent(activity, name)
                if (isFinish) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                }
                activity.startActivity(intent)
            })
        }


        fun startActivity(activity: Activity?, name: Class<*>?) {
            if (activity == null) {
                return
            }
            activity.runOnUiThread(Runnable {
                val intent = Intent(activity, name)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                activity.startActivity(intent)
            })
        }


        fun startFragment(activity: AppCompatActivity?, fragment: Fragment?) {
            if (activity == null) {
                return
            }
            activity.runOnUiThread(Runnable {
                val fm = activity.supportFragmentManager
                val fragmentTransaction = fm.beginTransaction()
            })
        }

    }
}