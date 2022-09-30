package com.whirlpool.prodigio_app.view.dialoges

import com.example.calculator_jch.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


open class BaseDlgBottomSheet : BottomSheetDialogFragment() {

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }
}