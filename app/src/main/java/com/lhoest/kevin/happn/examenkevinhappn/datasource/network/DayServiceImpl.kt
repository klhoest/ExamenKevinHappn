package com.lhoest.kevin.happn.examenkevinhappn.datasource.network

import com.lhoest.kevin.happn.examenkevinhappn.constant.Const
import com.lhoest.kevin.happn.examenkevinhappn.datasource.DayService
import com.lhoest.kevin.happn.examenkevinhappn.model.Day


class DayServiceImpl : DayService {

    private val dayApi: DayApi = RetrofitBuilder.provideRetrofit().create(DayApi::class.java)

    override suspend fun getDayList(): List<Day> {
        return dayApi.getForecast(Const.ID_PARIS, RetrofitBuilder.API_KEY).list
    }
}