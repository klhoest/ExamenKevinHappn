package com.lhoest.kevin.happn.examenkevinhappn.viewmodel

import androidx.lifecycle.*
import com.lhoest.kevin.happn.examenkevinhappn.dummy.DummyContent
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepository
import com.lhoest.kevin.happn.examenkevinhappn.util.ListUtils
import java.util.*

class ForecastViewModel constructor(private val dayRepo: DayRepository) : ViewModel() {

    var dayList: List<Day>? = null
    private var summaryItemList: MutableList<SummaryViewHolder>? = null

    val showLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    /**
     * @get will load the previously downloaded list or download a new one if it is non existent
     */
    val forcast: LiveData<MutableList<SummaryViewHolder>> = liveData {
        showLoading.value = true
        dayList = dayRepo.getDayList()
        summaryItemList = mapDayListToSummaryList(dayList!!).toMutableList()

        emit(summaryItemList!!)
        showLoading.value = false
    }

    fun onSummaryItemClicked(item: DummyContent.DummyItem) {
        throw NotImplementedError()
    }

    fun mapDayListToSummaryList(dayList: List<Day>): List<SummaryViewHolder> {
        return dayList
            .map { day -> SummaryViewHolder(day) }
            .groupBy { holder -> holder.date.getDayOfMonth() }
            .map { map -> ListUtils.getItemInTheMidle(map.value) }
    }

}

private fun Date.getDayOfMonth(): Int {
    val calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris")) //todo make dynamic
    calendar.time = this
    return calendar.get(Calendar.DAY_OF_MONTH)
}