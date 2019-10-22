package com.lhoest.kevin.happn.examenkevinhappn.datasource.network

import io.reactivex.Observable
import kevin.domain.model.Forecast
import retrofit2.http.GET
import retrofit2.http.Query


interface DayApi {
    @GET("data/2.5/weather")
    fun getForcast(
            @Query("id") cityId:Int,
            @Query("APPID") apiId:String
    ): Observable<Forecast>
}