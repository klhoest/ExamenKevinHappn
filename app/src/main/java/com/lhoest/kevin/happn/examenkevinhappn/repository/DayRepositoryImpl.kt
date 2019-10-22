package com.lhoest.kevin.happn.examenkevinhappn.repository

import com.lhoest.kevin.happn.examenkevinhappn.datasource.DayService
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class DayRepositoryImpl @Inject constructor(val dayService: DayService) : DayRepository {

    var lastForecast : List<Day>? = null

    override fun getDayList(size: Int?): Observable<List<Day>> {

        val networkObservable = dayService.getDayList()
                .retry(2)
                .doOnNext { list -> lastForecast = list }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { e: Throwable? -> System.out.print(e?.message) }


        return networkObservable
    }
}