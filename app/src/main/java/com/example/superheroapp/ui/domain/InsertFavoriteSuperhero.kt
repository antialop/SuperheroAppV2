package com.example.superheroapp.ui.domain

import com.example.superheroapp.data.SuperheroRepository
import com.example.superheroapp.data.database.entities.FavoriteSuperheroEntity
import javax.inject.Inject

class InsertFavoriteSuperhero @Inject constructor(
    private val repository: SuperheroRepository
){
    suspend operator fun invoke(favoriteSuperheroEntity: FavoriteSuperheroEntity){
        repository.insertFavoriteSuperhero(favoriteSuperheroEntity)
    }
}