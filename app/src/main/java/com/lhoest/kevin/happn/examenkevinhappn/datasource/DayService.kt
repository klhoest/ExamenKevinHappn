package com.lhoest.kevin.happn.examenkevinhappn.datasource

import com.lhoest.kevin.happn.examenkevinhappn.model.Day


interface DayService {
    suspend fun getDayList(): List<Day>?
}