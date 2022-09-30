package com.example.calculator_jch

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.calculator_jch.view.ScrCalculator
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {


    @Rule
    var mActivityRule: ActivityTestRule<ScrCalculator> =
        ActivityTestRule<ScrCalculator>(ScrCalculator::class.java)

}