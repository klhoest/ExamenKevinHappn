package com.lhoest.kevin.happn.examenkevinhappn.datasource.network

import com.lhoest.kevin.happn.examenkevinhappn.constant.Const
import com.lhoest.kevin.happn.examenkevinhappn.datasource.DayService
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import io.reactivex.Observable


class DayServiceImpl : DayService {

    private val dayApi: DayApi = RetrofitBuilder.provideRetrofit().create(DayApi::class.java)

    override fun getDayList(): Observable<List<Day>> {
        return dayApi.getForecast(Const.ID_PARIS, RetrofitBuilder.API_KEY)
                .map { forecast ->
                    forecast.list
                }
    }
}