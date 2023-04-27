package com.example.superheroapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.superheroapp.data.database.dao.FavoriteSuperheroDao
import com.example.superheroapp.data.database.entities.FavoriteSuperheroEntity

@Database(entities = [FavoriteSuperheroEntity::class], version = 1)
abstract class FavoriteSuperheroDatabase: RoomDatabase(){
    abstract fun getFavoriteSuperheroDao(): FavoriteSuperheroDao
}