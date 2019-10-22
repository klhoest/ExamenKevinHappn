package com.lhoest.kevin.happn.examenkevinhappn.repository

import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import io.reactivex.Observable

interface DayRepository {
    fun getDayList(size: Int? = null): Observable<List<Day>>
}