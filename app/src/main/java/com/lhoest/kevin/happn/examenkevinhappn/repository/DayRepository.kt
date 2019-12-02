package com.lhoest.kevin.happn.examenkevinhappn.repository

import com.lhoest.kevin.happn.examenkevinhappn.datasource.network.DayService
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import javax.inject.Inject

class DayRepository @Inject constructor(val dayService: DayService) {

    var lastForecast : List<Day>? = null

    suspend fun getDayList(size: Int? = null): List<Day> {

        val networkForecast = dayService.getDayList()
        lastForecast = networkForecast


        return networkForecast
    }
}