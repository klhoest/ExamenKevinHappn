package com.lhoest.kevin.happn.examenkevinhappn.datasource.network.prefetch

import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.lhoest.kevin.happn.examenkevinhappn.datasource.DayService
import kotlinx.coroutines.runBlocking
import java.io.File
import java.io.IOException
import java.lang.Exception


class PrefetchWorker(private val appContext: Context, workerParams: WorkerParameters, private val dayService: DayService)
    : Worker(appContext, workerParams) {

    private val TAG = PrefetchWorker::class.java.simpleName

    override fun doWork(): Result {
        //suspending this thread is ok
        return runBlocking { getForecast() }
    }

    private suspend fun getForecast(): ListenableWorker.Result {
        return try {
            val bytes = dayService.getRawForecast().bytes()
            val file = File(appContext.cacheDir, "forecast.json")
            file.writeBytes(bytes)
            Result.success()
        } catch (e: IOException) {
            //see https://futurestud.io/tutorials/retrofit-2-how-to-detect-network-and-conversion-errors-in-onfailure
            //I thougt Retrofit provided a special exception for netowrk error
            Log.w(TAG, e.message)
            Result.retry()
        } catch (e: Exception) { //avoid to do this in prod
            Log.e(TAG, e.message)
            Result.failure()
        }
    }
}