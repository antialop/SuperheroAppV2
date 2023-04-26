package com.example.superheroapp.data.network

import com.example.superheroapp.data.model.SuperheroDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    //La api me devuelve un Response<SuperHeroDataResponse>
    @GET("api/10160908800489474/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String): Response<SuperheroDataResponse>

}