package com.example.superheroapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.ui.domain.GetSuperheroesDetailsUseCase
import com.example.superheroapp.ui.domain.SuperHeroDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroDetailViewModel @Inject constructor(
    private val getSuperheroDetail: GetSuperheroesDetailsUseCase
) : ViewModel() {


    val superheroDetail = MutableLiveData<SuperHeroDetail>()

    fun postDetails(id: String){
        viewModelScope.launch {
            val result = getSuperheroDetail(id)
            superheroDetail.postValue(result)
        }
    }



}