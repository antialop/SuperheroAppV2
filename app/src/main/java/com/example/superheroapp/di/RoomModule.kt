package com.example.superheroapp.di

import android.content.Context
import androidx.room.Room
import com.example.superheroapp.data.database.FavoriteSuperheroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
     private const val FAVORITE_SUPERHERO_DATABASE = "favorite_superhero_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FavoriteSuperheroDatabase::class.java, FAVORITE_SUPERHERO_DATABASE).build()


    @Singleton
    @Provides
    fun provideFavSuperheroDao(db:FavoriteSuperheroDatabase) = db.getFavoriteSuperheroDao()
}