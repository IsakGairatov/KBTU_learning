package com.example.apiassignment.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MangaDatabase: RoomDatabase() {
    abstract fun getMangaDao(): MangaDao

    companion object {
        @Volatile
        private var instance: MangaDatabase? = null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance?: synchronized(Lock) {
            instance ?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context: Context): MangaDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MangaDatabase::class.java,
                "manga_database"
            ).build()
        }

    }
}