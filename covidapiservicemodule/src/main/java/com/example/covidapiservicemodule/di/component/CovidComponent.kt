package com.example.covidapiservicemodule.di.component

import au.com.carsales.basemodule.dependency.component.BaseApplicationComponent
import com.example.covidapiservicemodule.di.module.ApiModule
import com.example.covidapiservicemodule.ui.viewmodel.CovidApiViewModel
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApiModule::class,
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class]
)
interface CovidComponent: BaseApplicationComponent {
    fun getCovidApiViewModel(): CovidApiViewModel
}