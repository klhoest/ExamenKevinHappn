package com.lhoest.kevin.happn.examenkevinhappn.ui

import androidx.lifecycle.*
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepository
import javax.inject.Inject

class ForecastViewModel constructor(private val dayRepo: DayRepository) : ViewModel() {

    val showLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    /**
     * @get will load the previously downloaded list or download a new one if it is non existent
     */
    val forcast: LiveData<List<Day>> = liveData {
        showLoading.value = true
        val value = dayRepo.getDayList()
        emit(value)
        showLoading.value = false
    }

}