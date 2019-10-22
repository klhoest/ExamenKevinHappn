package kevin.repository

import io.reactivex.Observable
import kevin.domain.model.Day
import kevin.domain.model.Main
import kevin.domain.model.Weather
import kotlinx.coroutines.delay
import javax.inject.Inject


class DayRepositoryStub @Inject constructor() : DayRepository {
    override suspend fun getDayList(size: Int?): List<Day> {
        val stubMain1 = Main(1.0, 2.0, 3.0, 1000.0, 500.0, 700.0, 3, 50.0)
        val stubWeather = Weather(1, "cloud", "some clouds", null)
        val itemList = listOf(
                Day(1485799200, stubMain1, listOf(stubWeather), null, null, null, null, null)
        )
        delay(3000)
        return itemList
    }
}