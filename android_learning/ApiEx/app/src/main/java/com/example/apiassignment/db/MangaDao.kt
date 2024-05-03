package com.example.apiassignment.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.apiassignment.models.Manga
import com.example.apiassignment.models.MangaItem
import androidx.room.Query

interface MangaDao {

    @Query("SELECT * FROM mangas")
    suspend fun getAllmangas():LiveData<ArrayList<MangaItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(manga: MangaItem)

    @Delete()
    suspend fun delete(manga: MangaItem)
}