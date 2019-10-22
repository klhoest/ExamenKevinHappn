package com.lhoest.kevin.happn.examenkevinhappn.datasource.network.prefetch

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.lhoest.kevin.happn.examenkevinhappn.constant.BundleConst
import com.lhoest.kevin.happn.examenkevinhappn.datasource.DayService
import kevin.domain.model.Day


class PrefetchWorker(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val json = getForecast()
        return Result.success()
    }

    private fun getForecast(): List<Day> {
        DayService.getDayList()
    }
}