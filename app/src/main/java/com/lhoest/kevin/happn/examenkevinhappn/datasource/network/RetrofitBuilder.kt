package com.lhoest.kevin.happn.examenkevinhappn.datasource.network


import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitBuilder {

    companion object {
        const val BASE_URL = "api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=3cccc41563eac772856ab314db4185e0"
        const val API_KEY = "3cccc41563eac772856ab314db4185e0"

        fun provideRetrofit(): Retrofit {

            val httpClient = OkHttpClient.Builder()

            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(httpClient.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()
        }
    }

}