package com.lhoest.kevin.happn.examenkevinhappn.datasource

import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import okhttp3.ResponseBody


interface DayService {
    suspend fun getDayList(): List<Day>

    suspend fun getRawForecast() : ResponseBody
}