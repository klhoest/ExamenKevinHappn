package com.lhoest.kevin.happn.examenkevinhappn

import android.util.Log
import com.lhoest.kevin.happn.examenkevinhappn.datasource.network.DayServiceImpl
import com.lhoest.kevin.happn.examenkevinhappn.datasource.storage.DayDao
import com.lhoest.kevin.happn.examenkevinhappn.model.Day
import com.lhoest.kevin.happn.examenkevinhappn.repository.DayRepositoryImpl
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class DayRepositoryTest {

    val stubItemList = listOf(
            Day(-1, null, null, null, null, null, null, null)
    )

    @Test
    fun getDayListWithOnlyNetwork() {
        val networkService = mockk<DayServiceImpl>()
        val storageService = mockk<DayDao>()


        coEvery { networkService.getDayList() } returns stubItemList
        coEvery { storageService.getDayList() } returns emptyList()

        val dayRepo = DayRepositoryImpl(networkService)
        dayRepo.dayServiceStorage = storageService

        runBlocking {
            val result = dayRepo.getDayList()
            assertEquals(stubItemList, result)
        }
    }

    @Test
    fun getDayListWithOnlyStorage() {
        mockkStatic(Log::class)
        every { Log.v(any(), any()) } returns 0
        every { Log.d(any(), any()) } returns 0
        every { Log.i(any(), any()) } returns 0
        every { Log.e(any(), any()) } returns 0

        val networkService = mockk<DayServiceImpl>()
        val storageService = mockk<DayDao>()

        coEvery { networkService.getDayList() } returns emptyList()
        coEvery { storageService.getDayList() } returns stubItemList

        val dayRepo = DayRepositoryImpl(networkService)
        dayRepo.dayServiceStorage = storageService

        runBlocking {
            val result = dayRepo.getDayList()
            assertEquals(stubItemList, result)
        }
    }

    /**
     * assert that no result are returned
     */
    @Test
    fun getDayListWithNoDataSource() {
        val networkService = mockk<DayServiceImpl>()
        val storageService = mockk<DayDao>()

        coEvery { networkService.getDayList() } returns null
        coEvery { storageService.getDayList() } returns null

        val dayRepo = DayRepositoryImpl(networkService)
        dayRepo.dayServiceStorage = storageService

        runBlocking {
            val result = dayRepo.getDayList()
            assertEquals(null, result)
        }
    }
}
