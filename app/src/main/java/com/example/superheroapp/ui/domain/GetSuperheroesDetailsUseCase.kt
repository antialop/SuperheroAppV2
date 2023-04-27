package com.example.superheroapp.ui.domain

import com.example.superheroapp.data.SuperheroRepository
import javax.inject.Inject

class GetSuperheroesDetailsUseCase @Inject constructor(
    private val repository: SuperheroRepository
){

    suspend operator fun invoke(superheroId: String): SuperHeroDetail {
        return repository.getSuperheroDetailsFromApi(superheroId)
    }
}