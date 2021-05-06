package com.example.movietrackers.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietrackers.data.TopRatedMovies
import com.example.movietrackers.network.TmdbApi

import kotlinx.coroutines.launch

class TopRatedViewModel: ViewModel() {
    var pageNo = (1..435).random()

    private val _topRated = MutableLiveData<List<TopRatedMovies>>()
     val topRated: LiveData<List<TopRatedMovies>> = _topRated
    init {
        getTopRated()
    }

     fun getTopRated(){
        viewModelScope.launch {
            _topRated.value = TmdbApi.retrofitService.getTopRatedMovies(pageNo).results
        }
    }
}