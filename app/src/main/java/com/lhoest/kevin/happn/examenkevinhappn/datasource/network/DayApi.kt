package com.lhoest.kevin.happn.examenkevinhappn.datasource.network

import com.lhoest.kevin.happn.examenkevinhappn.model.Forecast
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query


interface DayApi {
    @GET("data/2.5/forecast")
    suspend fun getForecast(
            @Query("id") cityId: Int,
            @Query("APPID") apiId: String
    ): Forecast

    @GET("data/2.5/forecast")
    suspend fun getForecastRaw(
            @Query("id") cityId: Int,
            @Query("APPID") apiId: String
    ) : ResponseBody
}