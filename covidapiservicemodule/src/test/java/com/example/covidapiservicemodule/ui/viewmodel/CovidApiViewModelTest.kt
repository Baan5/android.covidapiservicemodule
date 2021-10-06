package com.example.covidapiservicemodule.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bangover.carsalescovid.util.TestCoroutineRule
import com.example.covidapiservicemodule.domain.GetTotalReportsUseCase
import com.example.covidapiservicemodule.util.CovidViewModelFactory
import com.example.covidapiservicemodule.util.GetDate
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CovidApiViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get: Rule
    var testCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: CovidApiViewModel
    private lateinit var factory: CovidViewModelFactory

    @Mock
    lateinit var getTotalReportsUseCase: GetTotalReportsUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = CovidApiViewModel(getTotalReportsUseCase)
        factory = CovidViewModelFactory()
    }

    @Test
    fun should_returnError_when_dataIsNull(){
        testCoroutineRule.runBlockingTest {
            val covidData = viewModel.getTotalReports(GetDate().getDateWithOneDayMore())
            assert(covidData == null)
        }
    }

    @Test
    fun should_returnSuccess_when_dataIsNotNull(){
        testCoroutineRule.runBlockingTest {
            Mockito.`when`(getTotalReportsUseCase.invoke(GetDate().getDateWithOneDayLess())).thenReturn(factory.getCovidData())
            val covidData = viewModel.getTotalReports(GetDate().getDateWithOneDayLess())
            assert(covidData != null)
        }
    }
}