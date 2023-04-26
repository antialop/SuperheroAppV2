package com.example.superheroapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.ui.domain.GetSuperheroesDetailsUseCase
import com.example.superheroapp.ui.domain.SuperHeroDetail
import kotlinx.coroutines.launch

class SuperheroDetailViewModel() : ViewModel() {

    private val getSuperheroDetail =  GetSuperheroesDetailsUseCase()
    val superheroDetail = MutableLiveData<SuperHeroDetail>()

    fun postDetails(id: String){
        viewModelScope.launch {
            val result = getSuperheroDetail(id)
            superheroDetail.postValue(result)
        }
    }



}