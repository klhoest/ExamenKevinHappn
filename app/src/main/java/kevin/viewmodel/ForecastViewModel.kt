package kevin.viewmodel

import androidx.lifecycle.*
import kevin.domain.model.Day
import kevin.repository.DayRepository
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