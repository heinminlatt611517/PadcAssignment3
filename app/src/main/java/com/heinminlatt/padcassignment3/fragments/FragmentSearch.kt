package com.heinminlatt.padcassignment3.fragments


import android.app.DatePickerDialog
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.heinminlatt.padcassignment3.Constants

import com.heinminlatt.padcassignment3.R
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.txt_rating
import kotlinx.android.synthetic.main.fragment_fragment_near_by.*
import kotlinx.android.synthetic.main.fragment_fragment_search.*
import kotlinx.android.synthetic.main.recent_hotel_items.*
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSearch.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSearch : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_fragment_search, container, false)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edt_location.setText(Constants.str)
        edt_checkIn.setText("\"--/--/----\"")
        edt_checkOut.setText("\"--/--/----\"")
        edt_checkIn.inputType=InputType.TYPE_NULL


        txt_rating.setText(rating.rating.toString())
        txt1_rating.setText(rating.rating.toString())
        txt2_rating.setText(rating.rating.toString())
        txt3_rating.setText(rating.rating.toString())


        rtxt_rating.setText(rrating.rating.toString())
        rtxt1_rating.setText(rrating.rating.toString())

        btn_search.setOnClickListener{

            val bottomSheetDialogFragment=BottomSheetFragment()
            activity?.supportFragmentManager?.let { it1 -> bottomSheetDialogFragment.show(it1,bottomSheetDialogFragment.tag)
            }
        }


        //create onDateSetListener
        val dateSetListener =object : DatePickerDialog.OnDateSetListener{
            override fun onDateSet(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {

                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                updateDateInview()

            }
        }

        val dateListener =object : DatePickerDialog.OnDateSetListener{
            override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                cal.set(Calendar.YEAR, p1)
                cal.set(Calendar.MONTH, p2)
                cal.set(Calendar.DAY_OF_MONTH, p3)

                updateDateInview1()
            }

        }


        edt_checkIn.setOnFocusChangeListener(object : View.OnFocusChangeListener{
            override fun onFocusChange(p0: View?, p1: Boolean) {

                if (p1){
                    activity?.let {
                        DatePickerDialog(
                            it,
                            dateSetListener,
                            // set DatePickerDialog to point to today's date when it loads up
                            cal.get(Calendar.YEAR),
                            cal.get(Calendar.MONTH),
                            cal.get(Calendar.DAY_OF_MONTH)).show()
                    }
                    if (p0 != null) {
                        p0.clearFocus()
                    }
                }

            }


        })

        edt_checkOut.setOnFocusChangeListener(object : View.OnFocusChangeListener{
            override fun onFocusChange(p0: View?, p1: Boolean) {

                if (p1){
                    activity?.let {
                        DatePickerDialog(
                            it,
                            dateListener,
                            // set DatePickerDialog to point to today's date when it loads up
                            cal.get(Calendar.YEAR),
                            cal.get(Calendar.MONTH),
                            cal.get(Calendar.DAY_OF_MONTH)).show()
                    }
                    if (p0 != null) {
                        p0.clearFocus()
                    }
                }

            }


        })


    }

    private fun updateDateInview1(){

        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)


        edt_checkOut.setText(sdf.format(cal.getTime()))
    }
    private fun updateDateInview(){
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)


        edt_checkIn.setText(sdf.format(cal.getTime()))
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentSearch.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSearch().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
