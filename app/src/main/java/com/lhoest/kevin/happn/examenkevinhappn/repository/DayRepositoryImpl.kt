package com.lhoest.kevin.happn.examenkevinhappn.repository

import com.lhoest.kevin.happn.examenkevinhappn.datasource.network.DayService
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import javax.inject.Inject

class DayRepositoryImpl @Inject constructor(val dayService: DayService) : DayRepository {

    var lastForecast : List<Day>? = null

    override suspend fun getDayList(size: Int?): List<Day> {

        val networkForecast = dayService.getDayList()
        lastForecast = networkForecast


        return networkForecast
    }
}