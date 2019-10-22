package com.lhoest.kevin.happn.examenkevinhappn.datasource

import io.reactivex.Observable
import kevin.domain.model.Day


interface DayService {
    fun getDayList(): Observable<List<Day>>
}