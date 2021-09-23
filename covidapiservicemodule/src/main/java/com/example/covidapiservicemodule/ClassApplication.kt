package com.example.covidapiservicemodule

import android.content.Context
import au.com.carsales.basemodule.BaseModuleApplication
import au.com.carsales.basemodule.router.BaseModuleLifeCycleManager
import com.example.covidapiservicemodule.di.component.CovidComponent
import com.example.covidapiservicemodule.di.component.DaggerCovidComponent
import com.example.covidapiservicemodule.service.ICovidApiReceivedService
import com.example.covidapiservicemodule.ui.viewmodel.CovidApiViewModel

class ClassApplication: BaseModuleApplication() {

    companion object {
        internal var covidComponent: CovidComponent? = null
        internal var covidApiViewModel: CovidApiViewModel? = null
    }

    override fun initLifeCycleManager(): BaseModuleLifeCycleManager {
        return BaseModuleLifeCycleManager(this)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent().inject(this)
    }

}

private fun buildDagger(context: Context): CovidComponent {
    if (ClassApplication.covidComponent == null){
        ClassApplication.covidComponent =
            DaggerCovidComponent
                .builder()
                .build()
    }
    return ClassApplication.covidComponent!!
}

fun Context.appComponent(): CovidComponent {
    return buildDagger(this)
}

fun getCovidApiViewModelInstance(context: Context): CovidApiViewModel? {
    context.let {
        ClassApplication.covidApiViewModel =
            context.appComponent().getCovidApiViewModel()
    }
    return ClassApplication.covidApiViewModel
}
