package com.lhoest.kevin.happn.examenkevinhappn

import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import com.lhoest.kevin.happn.examenkevinhappn.model.Main
import com.lhoest.kevin.happn.examenkevinhappn.model.Weather
import com.lhoest.kevin.happn.examenkevinhappn.viewmodel.SummaryViewHolder
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SummaryTest {

    /**
     * test SummaryViewHolder mapping from Day model
     * when temperature of the day is 100 Kelvin
     * expected print -173,1 °C
     */
    @Test
    fun constructSummaryViewHolderWith100kelvin() {
        val stubMain1 = Main(100.0, 2.0, 3.0, 1000.0, 500.0, 700.0, 3, 50.0)
        val stubWeather = Weather(1, "cloud", "some clouds", null)
        val stubDay = Day(1485799200, stubMain1, listOf(stubWeather), null, null, null, null, null)
        val viewHolder = SummaryViewHolder(stubDay)
        assertEquals("-173,1 °C", viewHolder.temperature)
    }
}
