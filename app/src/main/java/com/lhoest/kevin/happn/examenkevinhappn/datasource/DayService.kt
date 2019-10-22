package com.lhoest.kevin.happn.examenkevinhappn.datasource

import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import io.reactivex.Observable


interface DayService {
    fun getDayList(): Observable<List<Day>>
}