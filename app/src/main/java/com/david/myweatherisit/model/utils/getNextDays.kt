package com.david.myweatherisit.model.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun getNextDays( date: String): List<String>{
    val days = mutableListOf<String>()
    val formatDayHour = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val startDate = LocalDate.parse(date, formatDayHour)

    for(i in 1..4){
        val nextDay = startDate.plusDays(i.toLong())
        val dayOfWeek = nextDay.dayOfWeek
        days.add(dayOfWeek.toString())
    }
    return days
}