package com.example.calculator_jch.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.calculator_jch.R
import com.example.calculator_jch.constants.MyCostants.CM
import com.example.calculator_jch.constants.MyCostants.KILOMETER
import com.example.calculator_jch.constants.MyCostants.KM
import com.example.calculator_jch.constants.MyCostants.M
import com.example.calculator_jch.constants.MyCostants.METER
import com.example.calculator_jch.constants.MyCostants.MM
import com.example.calculator_jch.databinding.ActivityScrLengthMeasurementBinding
import com.example.calculator_jch.utils.CustomToast
import com.example.calculator_jch.view.model.Measurements
import com.example.calculator_jch.view.viewmodel.LengthMeasurementViewMmodel
import com.example.calculator_jch.view.viewmodel.LengthMeasurementViewModelFactory
import com.whirlpool.prodigio_app.view.dialoges.DlgDropDownAll

class ScrLengthMeasurement : AppCompatActivity(), DlgDropDownAll.BottomSheetDlgAllListner {

    private val TAG = ScrLengthMeasurement::class.java.name

    private lateinit var binding: ActivityScrLengthMeasurementBinding

    private val bottomDlg = DlgDropDownAll()
    private lateinit var viewmodel: LengthMeasurementViewMmodel

    private lateinit var from_measurement: Measurements
    private lateinit var to_measurement: Measurements
    private var isFrom = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scr_length_measurement)
        initUI()
        obverData()
    }

    fun initUI() {
        bottomDlg.mListner = this

        val viewModelFactory = LengthMeasurementViewModelFactory()
        viewmodel = ViewModelProvider(this, viewModelFactory)[LengthMeasurementViewMmodel::class.java]


        from_measurement = Measurements(KILOMETER, KM)
        to_measurement = Measurements(METER, M)

        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.btClearAll.setOnClickListener {
            binding.tvFromResult.text = "0"
            binding.tvToResult.text = "0"
        }

        binding.btClear.setOnClickListener {
            val length = binding.tvFromResult.length()
            if (length == 1) {
                binding.tvFromResult.text = "0"
            } else if (length > 0) {
                binding.tvFromResult.text = binding.tvFromResult.text.subSequence(0, length - 1)
            } else {
                binding.tvFromResult.text = "0"
            }
        }

        binding.bt9.setOnClickListener {
            ondigitCliicked("9")
        }
        binding.bt8.setOnClickListener {
            ondigitCliicked("8")
        }
        binding.bt7.setOnClickListener {
            ondigitCliicked("7")
        }
        binding.bt6.setOnClickListener {
            ondigitCliicked("6")
        }
        binding.bt5.setOnClickListener {
            ondigitCliicked("5")
        }
        binding.bt4.setOnClickListener {
            ondigitCliicked("4")
        }
        binding.bt3.setOnClickListener {
            ondigitCliicked("3")
        }
        binding.bt2.setOnClickListener {
            ondigitCliicked("2")
        }
        binding.bt1.setOnClickListener {
            ondigitCliicked("1")
        }
        binding.bt0.setOnClickListener {
            ondigitCliicked("0")
        }
        binding.btDot.setOnClickListener {
            ondigitCliicked(".")
        }

        binding.llFrom.setOnClickListener {
            isFrom = true
            bottomDlg.show(supportFragmentManager, TAG)
        }
        binding.llTo.setOnClickListener {
            isFrom = false
            bottomDlg.show(supportFragmentManager, TAG)
        }

        binding.tvFromResult.doAfterTextChanged {
            Log.d(TAG, "initUI: from rersult : ${it.toString()}")
            val length = it.toString().length
            val pos = it?.indexOf(".")

            if (length-1 !=  pos) {
                viewmodel.doCalculation(it.toString(),from_measurement,to_measurement)
            }

        }
    }

    fun obverData() {
        viewmodel.calculatedOutPut.observe(this
        ) {
            Log.d(TAG, "obverData:  it : $it")
            binding.tvToResult.text = it.toString()
        }
    }

    fun ondigitCliicked(num: String) {
        val length = binding.tvFromResult.text.length
        Log.d(TAG, "ondigitCliicked: text ${binding.tvFromResult.text.toString().equals("0")}")
        Log.d(TAG, "ondigitCliicked: text ${binding.tvFromResult.text}  length $length")
        if (binding.tvFromResult.text.toString().equals("0") || binding.tvFromResult.text.toString().equals(".")) {
            binding.tvFromResult.text = num
        } else {
            binding.tvFromResult.append(num)
        }
    }

    override fun onValueSelected(type: Measurements) {
        if (isFrom) {
            from_measurement = type
            binding.tvFrom.text = type.code
            binding.tvFromResultFullform.text = type.name
            bottomDlg.dismiss()
            viewmodel.doCalculation(binding.tvFromResult.text.toString(),from_measurement,to_measurement)
        } else {
            to_measurement = type
            binding.tvTo.text = type.code
            binding.tvToResultFullform.text = type.name
            bottomDlg.dismiss()
            viewmodel.doCalculation(binding.tvFromResult.text.toString(),from_measurement,to_measurement)
        }
    }

}