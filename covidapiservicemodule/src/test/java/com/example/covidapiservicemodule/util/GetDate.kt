package com.example.covidapiservicemodule.util

import java.text.SimpleDateFormat
import java.util.*

class GetDate {

    fun getDateWithOneDayMore(): String{
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        var fecha = Calendar.getInstance()
        fecha.time = Date()
        fecha.add(Calendar.DAY_OF_MONTH, +1)
        val currentDate = sdf.format(fecha.time)
        return currentDate
    }

    fun getDateWithOneDayLess(): String{
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        var fecha = Calendar.getInstance()
        fecha.time = Date()
        fecha.add(Calendar.DAY_OF_MONTH, -1)
        val currentDate = sdf.format(fecha.time)
        return currentDate
    }

}