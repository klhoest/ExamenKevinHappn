package com.lhoest.kevin.happn.examenkevinhappn.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.lhoest.kevin.happn.examenkevinhappn.dummy.DummyContent
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepository
import javax.inject.Inject

class ForecastViewModel constructor(private val dayRepo: DayRepository) : ViewModel() {

    var dayList: List<Day>? = null
    private var summaryItemList : MutableList<SummaryViewHolder>? = null

    val showLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun start(context: Context) {
        dayRepo.launchPrefetchWorker(context)
    }

    /**
     * @get will load the previously downloaded list or download a new one if it is non existent
     */
    val forcast: LiveData<MutableList<SummaryViewHolder>> = liveData {
        showLoading.value = true
        dayList = dayRepo.getDayList()
        summaryItemList = dayList!!.map { day -> SummaryViewHolder(day) }.toMutableList()
        emit(summaryItemList!!)
        showLoading.value = false
    }

    fun onSummaryItemClicked(item: DummyContent.DummyItem) {
        throw NotImplementedError()
    }

}