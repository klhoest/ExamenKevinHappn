package com.lhoest.kevin.happn.examenkevinhappn.datasource.network


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    companion object {
        const val BASE_URL = "https://api.openweathermap.org"
        const val API_KEY = "3cccc41563eac772856ab314db4185e0"

        fun provideRetrofit(): Retrofit {

            val httpClient = OkHttpClient.Builder()

            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
        }
    }

}