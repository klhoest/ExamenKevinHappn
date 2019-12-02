package com.lhoest.kevin.happn.examenkevinhappn.datasource.network

import com.lhoest.kevin.happn.examenkevinhappn.constant.Const
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import javax.inject.Inject


class DayService @Inject constructor() {

    private val dayApi: DayApi = RetrofitBuilder.provideRetrofit().create(DayApi::class.java)

    suspend fun getDayList(): List<Day> {
        return dayApi.getForecast(Const.ID_PARIS, RetrofitBuilder.API_KEY).list
    }
}