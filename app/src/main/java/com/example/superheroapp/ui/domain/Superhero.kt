package com.example.superheroapp.ui.domain

import com.example.superheroapp.data.model.SuperheroDataResponse
import com.google.gson.annotations.SerializedName

data class SuperHero(
    val response: String,
    val superheroes: List<SuperheroItem>?
)

data class SuperheroItem(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage: SuperheroImage
)

data class SuperheroImage(val url:String)

fun SuperheroDataResponse.toDomain() = SuperHero(response,superheroes)
