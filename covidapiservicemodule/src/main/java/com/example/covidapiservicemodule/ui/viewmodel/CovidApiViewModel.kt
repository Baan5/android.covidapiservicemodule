package com.example.covidapiservicemodule.ui.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.example.covidapiservicemodule.data.model.CovidModel
import com.example.covidapiservicemodule.domain.GetTotalReportsUseCase
import javax.inject.Inject

class CovidApiViewModel @Inject constructor(private val getTotalReportsUseCase: GetTotalReportsUseCase): ViewModel() {

    @SuppressLint("CheckResult")
    suspend fun getTotalReports(date:String): CovidModel?{
        return getTotalReportsUseCase(date)
    }

}