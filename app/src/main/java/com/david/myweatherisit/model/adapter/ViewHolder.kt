package com.david.myweatherisit.model.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.david.myweatherisit.R

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val imageFirst = view.findViewById<ImageView>(R.id.idImageItem1)

    val dayFirst = view.findViewById<TextView>(R.id.idDayItem1)

    val tempFirst = view.findViewById<TextView>(R.id.idTempItem1)

}