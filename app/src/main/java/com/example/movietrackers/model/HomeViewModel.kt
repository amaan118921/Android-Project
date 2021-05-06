package com.example.movietrackers.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietrackers.data.Shows

import com.example.movietrackers.network.HomeApi
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {



    private val _home = MutableLiveData<List<Shows>>()
    val home : LiveData<List<Shows>> = _home

    init {
        getHomeMovies()
    }

    private fun getHomeMovies()
    {
        viewModelScope.launch {
            _home.value = HomeApi.retrofitService.getHome().results
        }
    }

}