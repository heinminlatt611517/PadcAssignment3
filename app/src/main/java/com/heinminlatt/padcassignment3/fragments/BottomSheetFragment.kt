package com.heinminlatt.padcassignment3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.heinminlatt.padcassignment3.R
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.bottom_sheet.view.txt_cancle
import java.util.ArrayList

class BottomSheetFragment : BottomSheetDialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      txt_cancle.setOnClickListener { this.dismiss() }
        val dataCollection: ArrayAdapter<String>? = activity?.let {
            ArrayAdapter(
                it,android.R.layout.simple_dropdown_item_1line,resources.getStringArray(R.array.autocompletetext_array)
            )
        }

        edt_price.setAdapter(dataCollection)

    }
}