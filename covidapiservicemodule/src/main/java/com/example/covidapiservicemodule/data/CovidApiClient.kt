package com.example.covidapiservicemodule.data

import com.example.covidapiservicemodule.data.model.CovidModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CovidApiClient {

    @GET("total")
    suspend fun getTotalReports(@Header("X-RapidAPI-Key") apiKey:String, @Query("date") date:String): Response<CovidModel>


}