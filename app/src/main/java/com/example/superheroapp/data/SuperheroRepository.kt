package com.example.superheroapp.data

import com.example.superheroapp.data.network.SuperheroService
import com.example.superheroapp.ui.domain.SuperHero
import com.example.superheroapp.ui.domain.SuperHeroDetail
import com.example.superheroapp.ui.domain.toDomain
import javax.inject.Inject

class SuperheroRepository @Inject constructor(
    private val api:SuperheroService
){
    //Esta funcion me devuelve un SuperHero, que es el modelo que sigue la ui
    suspend fun getSuperheroByName(superheroName: String) : SuperHero {
        //Pero la api sigue el modelo SuperheroDataResponse por eso le hago toDomain()
        //cambio de modelo de data a ui
        return api.getSuperheroes(superheroName).toDomain()
    }
    suspend fun getSuperheroDetails(superheroId: String): SuperHeroDetail {
        return api.getSuperHeroInformation(superheroId).toDomain()
    }
}