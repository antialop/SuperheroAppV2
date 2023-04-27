package com.example.superheroapp.data

import com.example.superheroapp.data.database.dao.FavoriteSuperheroDao
import com.example.superheroapp.data.database.entities.FavoriteSuperheroEntity
import com.example.superheroapp.data.network.SuperheroService
import com.example.superheroapp.ui.domain.SuperHero
import com.example.superheroapp.ui.domain.SuperHeroDetail
import com.example.superheroapp.ui.domain.toDomain
import javax.inject.Inject

class SuperheroRepository @Inject constructor(
    private val api:SuperheroService,
    private val favoriteSuperheroDao: FavoriteSuperheroDao
){
    //Esta funcion me devuelve un SuperHero, que es el modelo que sigue la ui
    suspend fun getSuperheroByNameFromApi(superheroName: String) : SuperHero {
        //Pero la api sigue el modelo SuperheroDataResponse por eso le hago toDomain()
        //cambio de modelo de data a ui
        return api.getSuperheroes(superheroName).toDomain()
    }
    suspend fun getSuperheroDetailsFromApi(superheroId: String): SuperHeroDetail {
        return api.getSuperHeroInformation(superheroId).toDomain()
    }
    suspend fun getFavoritesFromDatabase(): List<FavoriteSuperheroEntity>{
        return favoriteSuperheroDao.getAllFavoritesSuperheroes()
    }
    suspend fun insertFavoriteSuperhero(favoriteSuperhero:FavoriteSuperheroEntity){
        favoriteSuperheroDao.insertFavoriteSuperhero(favoriteSuperhero)
    }
    suspend fun removeFavSuperhero(favoriteSuperhero: String){
        favoriteSuperheroDao.removeFavoriteSuperhero(favoriteSuperhero)
    }



}