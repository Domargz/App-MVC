package com.david.myweatherisit.model.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.david.myweatherisit.R
import com.david.myweatherisit.model.dto.Forecastday

class RecyclerAdapter(val forecastDay: List<Forecastday>, val nextDays: List<String>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_forecast, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dayFirst.text = nextDays[position]
        holder.tempFirst.text = forecastDay[position].day.maxtemp_c.toString()
        Glide.with(holder.imageFirst.context).load("https:${forecastDay[position].day.condition.icon}").into(holder.imageFirst)
    }

    override fun getItemCount(): Int = forecastDay.size

}