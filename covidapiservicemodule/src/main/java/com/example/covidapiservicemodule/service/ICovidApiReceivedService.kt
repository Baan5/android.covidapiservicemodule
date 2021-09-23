package com.example.covidapiservicemodule.service

import com.example.covidapiservicemodule.data.model.CovidModel

interface ICovidApiReceivedService {

    suspend fun getData(date: String): CovidModel?

}