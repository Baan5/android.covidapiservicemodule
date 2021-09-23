package com.example.covidapiservicemodule.service

import com.example.covidapiservicemodule.data.model.CovidModel

interface ICovidApiService {

    suspend fun getTotalReportService(date: String): CovidModel?

}