package com.example.superheroapp.ui.domain

import com.example.superheroapp.data.SuperheroRepository

class GetSuperheroesDetailsUseCase {
    private val repository = SuperheroRepository()
    suspend operator fun invoke(superheroId: String): SuperHeroDetail {
        return repository.getSuperheroDetails(superheroId)
    }
}