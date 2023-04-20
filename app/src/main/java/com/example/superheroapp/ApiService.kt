package com.example.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/10160908800489474/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperHeroDataResponse>

    @GET("api/10160908800489474/id}")
    suspend fun getSuperheroesDetail(@Path("id") superheroId:String):Response<SuperHeroDetailResponse>

}