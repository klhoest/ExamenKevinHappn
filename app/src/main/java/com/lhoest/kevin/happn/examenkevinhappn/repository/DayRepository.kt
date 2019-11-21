package com.lhoest.kevin.happn.examenkevinhappn.repository

import com.lhoest.kevin.happn.examenkevinhappn.datasource.storage.DayDao
import com.lhoest.kevin.happn.examenkevinhappn.model.Day

interface DayRepository {
    var dayServiceStorage : DayDao?
    suspend fun getDayList(size: Int? = null): List<Day>?
}