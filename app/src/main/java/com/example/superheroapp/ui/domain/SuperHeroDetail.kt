package com.example.superheroapp.ui.domain

import com.example.superheroapp.data.model.SuperheroDetailResponse
import com.google.gson.annotations.SerializedName

data class SuperHeroDetail(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStats,
    @SerializedName("image") val image: SuperheroImageDetail,
    @SerializedName("biography") val biography: Biography
)


data class PowerStats(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class SuperheroImageDetail(@SerializedName("url") val url: String)

data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("publisher") val publisher: String
)

fun SuperheroDetailResponse.toDomain() = SuperHeroDetail(name,powerstats,image,biography)