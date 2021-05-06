package com.example.movietrackers.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietrackers.data.MovieDataClass
import com.example.movietrackers.network.MovieApi
import kotlinx.coroutines.launch

class TVShowViewModel: ViewModel() {
    var pageNo = (1..100).random()

    private val _photos = MutableLiveData<List<MovieDataClass>>()
     val photos: LiveData<List<MovieDataClass>> = _photos
        init {
            getShows()
        }

         fun getShows()
        {
            viewModelScope.launch {
                _photos.value = MovieApi.retrofitService.getPhotos(pageNo).tvShow
            }
        }


}