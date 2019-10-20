package kevin.repository

import kevin.domain.model.Day

interface DayRepository {
    suspend fun getDayList(size: Int? = null): List<Day>
}