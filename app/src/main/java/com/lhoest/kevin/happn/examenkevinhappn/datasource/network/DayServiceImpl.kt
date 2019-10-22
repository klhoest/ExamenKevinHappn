package com.lhoest.kevin.happn.examenkevinhappn.datasource.network

import com.lhoest.kevin.happn.examenkevinhappn.datasource.DayService
import io.reactivex.Observable
import kevin.domain.model.Day


class DayServiceImpl : DayService {

    val dayApi: DayApi = RetrofitBuilder.provideRetrofit().create(DayApi::class.java)

    override fun getFullItemList(): Observable<List<Day>> {
        return dayApi.getForcast()
    }
}