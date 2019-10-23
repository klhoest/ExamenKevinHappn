package com.lhoest.kevin.happn.examenkevinhappn.viewmodel

import androidx.lifecycle.*
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepository
import javax.inject.Inject

class ForecastViewModel constructor(private val dayRepo: DayRepository) : ViewModel() {

    var dayList: List<Day>? = null

    val showLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    /**
     * @get will load the previously downloaded list or download a new one if it is non existent
     */
    val forcast: LiveData<List<SummaryViewHolder>> = liveData {
        showLoading.value = true
        dayList = dayRepo.getDayList()
        val value = dayList!!.map { day -> SummaryViewHolder(day) }
        emit(value)
        showLoading.value = false
    }

}