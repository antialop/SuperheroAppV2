package com.example.superheroapp.ui.domain

import com.example.superheroapp.data.SuperheroRepository

class GetSuperheroesUseCase {
    private val repository = SuperheroRepository()
    //En vez de query he cambiado el nombre a superheroName ya que es el nombre con el que voy a buscar
    //El invoke es para cuando llames a la clase ya se ejecuta la funcion
    //Este metodo devuelve la funcion del repositorio getAllSuperheroes que devuelve los superheroes por nombre
    // que le pasamos el name, que es la query
    suspend operator fun invoke(superheroName: String) = repository.getSuperheroByName(superheroName)

}