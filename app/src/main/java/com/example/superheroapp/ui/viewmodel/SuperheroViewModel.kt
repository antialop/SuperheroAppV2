package com.example.superheroapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.ui.domain.GetSuperheroesUseCase
import com.example.superheroapp.ui.domain.SuperheroItem
import kotlinx.coroutines.launch

class SuperheroViewModel : ViewModel() {

    val superHeroDataResponse = MutableLiveData<List<SuperheroItem>>()
    var getSuperheroUseCase = GetSuperheroesUseCase()


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


}



