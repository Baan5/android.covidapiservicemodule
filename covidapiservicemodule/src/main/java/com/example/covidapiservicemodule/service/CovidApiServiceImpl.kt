package com.example.covidapiservicemodule.service

import au.com.carsales.basemodule.context
import com.example.covidapiservicemodule.data.model.CovidModel
import com.example.covidapiservicemodule.domain.GetTotalReportsUseCase
import com.example.covidapiservicemodule.getCovidApiViewModelInstance
import com.example.covidapiservicemodule.service.ICovidApiService
import javax.inject.Inject

class CovidApiServiceImpl: ICovidApiService {

    override suspend fun getTotalReportService(date: String): CovidModel?{
        return getCovidApiViewModelInstance(context!!)?.getTotalReports(date)
    }
}