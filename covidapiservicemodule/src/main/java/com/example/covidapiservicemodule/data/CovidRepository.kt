package com.example.covidapiservicemodule.data

import android.util.Log
import com.example.covidapiservicemodule.data.model.CovidModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import java.lang.Exception
import javax.inject.Inject

class CovidRepository @Inject constructor(private val api: Retrofit){

    private val apiKey = "96afa298cbmsh913f910f914494cp110c39jsn01a32d68445e"

    suspend fun getTotalReports(date:String): CovidModel? {

        return withContext(Dispatchers.IO){
            try {
                val response = api.create(CovidApiClient::class.java).getTotalReports(apiKey, date)
                Log.d("TAG", response.body().toString())
                response.body()
            }catch (e: Exception){
                Log.d("TAG", "getTotalReports: " + e.message)
                null
            }

        }
    }

}