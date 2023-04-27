package com.example.superheroapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.superheroapp.data.database.entities.FavoriteSuperheroEntity

@Dao
interface FavoriteSuperheroDao {

    @Query("SELECT * FROM favorites_table")
    suspend fun getAllFavoritesSuperheroes(): List<FavoriteSuperheroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteSuperhero(favoriteSuperheroEntity: FavoriteSuperheroEntity)
    @Query("DELETE FROM favorites_table WHERE idFavorite = :idFavorite")
    suspend fun removeFavoriteSuperhero(idFavorite: String)
}