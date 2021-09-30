package com.example.covidapiservicemodule.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bangover.carsalescovid.util.TestCoroutineRule
import com.example.covidapiservicemodule.domain.GetTotalReportsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.Parameterized.Parameters
import org.mockito.Mock
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

    @Mock
    lateinit var getTotalReportsUseCase: GetTotalReportsUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = CovidApiViewModel(getTotalReportsUseCase)
    }

    @Test
    @Parameters
    fun runTest(){
        testCoroutineRule.runBlockingTest {
            viewModel.getTotalReports("2021-09-30")
        }
    }
}