package com.lhoest.kevin.happn.examenkevinhappn.repository

import android.util.Log
import com.lhoest.kevin.happn.examenkevinhappn.datasource.DayService
import com.lhoest.kevin.happn.examenkevinhappn.datasource.storage.DayDao
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import com.lhoest.kevin.happn.examenkevinhappn.util.ErrorUtils
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class DayRepositoryImpl @Inject constructor(val dayService: DayService) : DayRepository {

    private val TAG = DayRepositoryImpl::class.simpleName

    override var dayServiceStorage: DayDao? = null
    val useStorageFallback = true
    var lastForecast : List<Day>? = null
    set(list) {
        if (list == null || list.isEmpty())
            return
        field = list
        GlobalScope.launch {
            list.forEach { day -> dayServiceStorage!!.insert(day) }
        }
    }

    override suspend fun getDayList(size: Int?): List<Day>? {
        try {
            val networkForecast = dayService.getDayList()
            lastForecast = networkForecast
            if (lastForecast != null)
                return lastForecast as List<Day>
        } catch (e : Exception) {
            if(!useStorageFallback) {
                throw e
            } else
                Log.w(TAG, e.message)
        }
        lastForecast = dayServiceStorage?.getDayList()
        return lastForecast
    }
}