package com.example.superheroapp.data.network

import com.example.superheroapp.core.RetrofitHelper
import com.example.superheroapp.data.model.SuperheroDataResponse
import com.example.superheroapp.data.model.SuperheroDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SuperheroService () {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getSuperheroes(superheroName: String): SuperheroDataResponse{
        //Llamada a la api, las llamadas al back hay que ponerlas en una corrutina
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiService::class.java).getSuperheroes(superheroName)
            //La api me devuelve Response<SuperHeroDataResponse> por lo que accede al body que es SuperheroDataResponse, lo que me devuelve esta funcion
            response.body()!!
        }
    }
    suspend fun getSuperHeroInformation(superheroId: String) : SuperheroDetailResponse {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ApiService::class.java).getSuperheroesDetail(superheroId)
            response.body()!!
        }

    }
}