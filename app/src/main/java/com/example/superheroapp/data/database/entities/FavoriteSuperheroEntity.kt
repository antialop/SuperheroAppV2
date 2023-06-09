package com.example.superheroapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.superheroapp.ui.domain.SuperheroItem

@Entity(tableName = "favorites_table")
data class FavoriteSuperheroEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "idFavorite") val idFavorite: String

)
fun SuperheroItem.toDatabase() = FavoriteSuperheroEntity(idFavorite = superheroId)