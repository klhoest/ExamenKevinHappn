package com.lhoest.kevin.happn.examenkevinhappn.datasource.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lhoest.kevin.happn.examenkevinhappn.model.Day

/**
 * see https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/index.html?index=..%2F..index#6
 */
@Database(entities = arrayOf(Day::class), version = 1, exportSchema = false)
abstract class DayRoomDatabase : RoomDatabase() {

    abstract fun dayDao(): DayDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DayRoomDatabase? = null

        fun getDatabase(context: Context): DayRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        DayRoomDatabase::class.java,
                        "day_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}