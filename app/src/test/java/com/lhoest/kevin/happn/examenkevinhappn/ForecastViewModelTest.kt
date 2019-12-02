package com.lhoest.kevin.happn.examenkevinhappn

import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import com.lhoest.kevin.happn.examenkevinhappn.model.Main
import com.lhoest.kevin.happn.examenkevinhappn.model.Weather
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepository
import com.lhoest.kevin.happn.examenkevinhappn.viewmodel.ForecastViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.*

class ForecastViewModelTest {

    @Test
    fun mapDayListToSummaryList() {
        val repoStub = mockk<DayRepository>()

        val stubMain1 = Main(1.0, 2.0, 3.0, 1000.0, 500.0, 700.0, 3, 50.0)
        val stubWeather = Weather(1, "cloud", "some clouds", null)
        val itemList = listOf(
                Day(1485799200, stubMain1, listOf(stubWeather), null, null, null, null, null)
        )

        //if we want to mock a list we must mock list.size and list.iterator
        coEvery { repoStub.getDayList() } returns itemList

        val viewModel = ForecastViewModel(repoStub)
        runBlocking {
            val dayList: List<Day> = repoStub.getDayList()
            val summaryList = viewModel.mapDayListToSummaryList(dayList)
            assertEquals(1, summaryList.size)
            assertEquals("some clouds", summaryList.first().subTitle)
        }
    }
}