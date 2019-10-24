package com.lhoest.kevin.happn.examenkevinhappn.repository

import android.content.Context
import com.lhoest.kevin.happn.examenkevinhappn.model.Day

interface DayRepository {
    suspend fun getDayList(size: Int? = null): List<Day>
    fun launchPrefetchWorker(context: Context)
}