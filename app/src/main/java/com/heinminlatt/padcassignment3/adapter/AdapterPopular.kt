package com.heinminlatt.padcassignment3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.heinminlatt.padcassignment3.R
import com.heinminlatt.padcassignment3.views.viewholder.NewViewHolder
import kotlinx.android.synthetic.main.bottom_sheet.*

class AdapterPopular : RecyclerView.Adapter<NewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_popular_items,parent,false)
        return NewViewHolder(view)
    }

    override fun getItemCount(): Int {
       return 6
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
    }
}