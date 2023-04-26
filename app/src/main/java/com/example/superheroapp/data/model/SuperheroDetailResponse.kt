package com.example.superheroapp.data.model

import com.example.superheroapp.ui.domain.Biography
import com.example.superheroapp.ui.domain.PowerStats
import com.example.superheroapp.ui.domain.SuperheroImageDetail
import com.google.gson.annotations.SerializedName

data class SuperheroDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStats,
    @SerializedName("image") val image: SuperheroImageDetail,
    @SerializedName("biography") val biography: Biography
)