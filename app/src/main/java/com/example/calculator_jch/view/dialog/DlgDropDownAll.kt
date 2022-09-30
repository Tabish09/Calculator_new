package com.whirlpool.prodigio_app.view.dialoges

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator_jch.R
import com.example.calculator_jch.constants.MyCostants.CENTIMETER
import com.example.calculator_jch.constants.MyCostants.CM
import com.example.calculator_jch.constants.MyCostants.KILOMETER
import com.example.calculator_jch.constants.MyCostants.KM
import com.example.calculator_jch.constants.MyCostants.M
import com.example.calculator_jch.constants.MyCostants.METER
import com.example.calculator_jch.constants.MyCostants.MILIMETER
import com.example.calculator_jch.constants.MyCostants.MM
import com.example.calculator_jch.databinding.DlgDropDownAllBinding
import com.example.calculator_jch.view.model.Measurements
import com.example.calculator_jch.view.adapter.DropDownAllAdapter

class DlgDropDownAll : BaseDlgBottomSheet(), DropDownAllAdapter.onItemSelectedListner {

    private val TAG = DlgDropDownAll::class.java.name

    private lateinit var binding: DlgDropDownAllBinding
    private lateinit var items: ArrayList<String>
    lateinit var mListner: BottomSheetDlgAllListner
    private lateinit var mAdapter: DropDownAllAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.dlg_drop_down_all, container, false)
        val rootView = binding.root
        init()
        registerClicks()
        return rootView
    }

    fun init() {
        val list = ArrayList<Measurements>()
        list.add(Measurements(KILOMETER, KM))
        list.add(Measurements(METER, M))
        list.add(Measurements(CENTIMETER, CM))
        list.add(Measurements(MILIMETER, MM))

        mAdapter = DropDownAllAdapter(list, this)
        binding.rvOptions.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter
            binding.rvOptions.adapter = adapter
            binding.rvOptions.adapter?.notifyDataSetChanged()
        }
    }

    private fun registerClicks() {

    }

    interface BottomSheetDlgAllListner {
        fun onValueSelected(type: Measurements)
    }

    override fun onItemSelected(type: Measurements) {
        Log.d(TAG, "onItemSelected: type : $type")
        mListner.onValueSelected(type)

    }

}