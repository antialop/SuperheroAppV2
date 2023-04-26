package com.example.superheroapp.di

import com.example.superheroapp.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Dependecias de librerias o de clases que contienen interfaces
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton //Mantener una unica instancia de Retrofit
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

}