package com.lhoest.kevin.happn.examenkevinhappn

import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepositoryStub
import com.lhoest.kevin.happn.examenkevinhappn.viewmodel.ForecastViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.*

class ForecastViewModelTest {

    @Test
    fun mapDayListToSummaryList() {
        val repoStub = DayRepositoryStub()
        val viewModel = ForecastViewModel(repoStub)
        runBlocking {
            val dayList: List<Day> = repoStub.getDayList()
            val summaryList = viewModel.mapDayListToSummaryList(dayList)
            assertEquals(1, summaryList.size)
            assertEquals("some clouds", summaryList.first().subTitle)
        }
    }
}