package com.example.superheroapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.data.database.entities.toDatabase
import com.example.superheroapp.ui.domain.RemoveFavoriteSuperhero
import com.example.superheroapp.ui.domain.GetSuperheroesUseCase
import com.example.superheroapp.ui.domain.InsertFavoriteSuperhero
import com.example.superheroapp.ui.domain.SuperheroItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroViewModel @Inject constructor(
    var getSuperheroUseCase:GetSuperheroesUseCase,
    private val insertFavoriteSuperhero: InsertFavoriteSuperhero,
    private val removeFavoriteSuperhero: RemoveFavoriteSuperhero
) : ViewModel() {

    val superHeroDataResponse = MutableLiveData<List<SuperheroItem>>()


    fun searchByName(query: String) {
        viewModelScope.launch {
            //Result es de tipo Superhero
            val result = getSuperheroUseCase(query)
            if(result.response=="error"){
                superHeroDataResponse.postValue(emptyList())
            }else{
                superHeroDataResponse.postValue(result.superheroes!!)
            }
        }
    }

    fun insertFavoriteSuperhero(superheroItem: SuperheroItem){
        viewModelScope.launch {
            insertFavoriteSuperhero(superheroItem.toDatabase())
        }
    }
    fun deleteFavoriteSuperhero(superheroId: String) {
        viewModelScope.launch {
            removeFavoriteSuperhero(superheroId)
        }
    }
}



