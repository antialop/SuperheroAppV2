package com.example.superheroapp.ui.domain

import com.example.superheroapp.data.SuperheroRepository

class GetSuperheroesUseCase {
    private val repository = SuperheroRepository()
    suspend operator fun invoke(superheroName: String) = repository.getAllSuperheroes(superheroName)

}