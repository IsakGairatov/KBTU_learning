package com.example.apiassignment.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "mangas")
data class MangaItem(
    @PrimaryKey(autoGenerate = true)
    val idd: Int? = null,

    val aired_on: String,
    val chapters: Int,
    val id: Int,
    val image: Image,
    val kind: String,
    val name: String,
    val released_on: Any,
    val russian: String,
    val score: String,
    val status: String,
    val url: String,
    val volumes: Int
)