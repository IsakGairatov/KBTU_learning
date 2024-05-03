package com.example.apiassignment.data.api

import javax.inject.Inject

class TestRepo @Inject constructor(private val mangaServ: MangaService){
    suspend fun getAll() = mangaServ.getMangalist()
}