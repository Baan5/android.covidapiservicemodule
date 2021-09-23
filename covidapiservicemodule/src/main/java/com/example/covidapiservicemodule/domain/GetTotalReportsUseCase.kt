package com.example.covidapiservicemodule.domain

import com.example.covidapiservicemodule.data.CovidRepository
import com.example.covidapiservicemodule.data.model.CovidModel
import javax.inject.Inject

class GetTotalReportsUseCase @Inject constructor(val repository: CovidRepository){

    suspend operator fun invoke(date:String): CovidModel? = repository.getTotalReports(date)

}