package com.lhoest.kevin.happn.examenkevinhappn.datasource.network

import com.lhoest.kevin.happn.examenkevinhappn.model.Forecast
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface DayApi {
    @GET("data/2.5/forecast")
    fun getForecast(
            @Query("id") cityId: Int,
            @Query("APPID") apiId: String
    ): Observable<Forecast>
}