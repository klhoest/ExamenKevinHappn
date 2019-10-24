package com.lhoest.kevin.happn.examenkevinhappn.repository

import android.content.Context
import androidx.work.*
import com.google.gson.Gson
import com.lhoest.kevin.happn.examenkevinhappn.datasource.DayService
import com.lhoest.kevin.happn.examenkevinhappn.datasource.network.prefetch.PrefetchWorker
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import com.lhoest.kevin.happn.examenkevinhappn.model.Forecast
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import javax.inject.Inject

class DayRepositoryImpl @Inject constructor(val dayService: DayService) : DayRepository {

    var lastForecast : List<Day>? = null
    private val gson :Gson = Gson()
    private val workerConstraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .build()

    private val uploadWorkRequest = OneTimeWorkRequestBuilder<PrefetchWorker>()
            .setConstraints(workerConstraints)
            .build()

    override suspend fun getDayList(size: Int?): List<Day> {
        val networkForecast = dayService.getDayList()
        lastForecast = networkForecast


        return networkForecast
    }

    override fun launchPrefetchWorker(context: Context) {
        WorkManager.getInstance(context).enqueue(uploadWorkRequest)
    }

    @Suppress("SENSELESS_COMPARISON")
    fun findJson(context : Context): Forecast? {
        var fileReader: FileReader? = null
        try {
            val file = File(context.cacheDir, "forecast.json")
            fileReader = FileReader(file)
            if (fileReader != null) { //java methods are not null safe
                val result = gson.fromJson(fileReader, Forecast::class.java)
                fileReader.close()
                return result
            }
        } catch (ex: Exception) {
            //see https://discuss.kotlinlang.org/t/does-kotlin-have-multi-catch/486/4
            when (ex) {
                is FileNotFoundException,
                is IOException -> {
                    println(ex.message)
                }
                else -> throw ex
            }
        } finally {
            fileReader?.close()
        }
        return null
    }
}