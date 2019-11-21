package com.lhoest.kevin.happn.examenkevinhappn.datasource.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lhoest.kevin.happn.examenkevinhappn.datasource.DayService
import com.lhoest.kevin.happn.examenkevinhappn.model.Day

@Dao
interface DayDao : DayService{

    @Query("SELECT * from day_table")
    override suspend fun getDayList(): List<Day>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(day: Day)

    @Query("DELETE FROM day_table")
    suspend fun deleteAll()
}