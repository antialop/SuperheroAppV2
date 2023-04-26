package com.example.superheroapp.data.model

import com.example.superheroapp.ui.domain.SuperheroItem
import com.google.gson.annotations.SerializedName

//Si las variables no se llaman igual que en JSON que recibimos, hay que poner la etiqueta @SerializedName
//Aqui guardo lo que me viene de la Api
data class SuperheroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes:List<SuperheroItem>
    )