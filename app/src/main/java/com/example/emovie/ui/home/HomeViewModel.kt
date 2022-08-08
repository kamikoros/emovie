package com.example.emovie.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emovie.data.model.Option
import com.example.emovie.data.model.TypeCategory
import com.example.emovie.domain.GetDataGenre
import com.example.emovie.domain.GetListMovie
import com.example.emovie.domain.modulo.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMovie:GetListMovie,private val getGenre:GetDataGenre)  :ViewModel() {
     val listUpComing = MutableLiveData<List<Movie>>()
     val listTopRated = MutableLiveData<List<Movie>>()
     val listRecommended = MutableLiveData<List<Movie>>()
    init {
        setUpComing()
        setTopRated()
        getDataGenres()
    }

    fun getDataGenres(){
        viewModelScope.launch(Dispatchers.IO) {
           getGenre()
        }
    }
    fun setUpComing(){
        viewModelScope.launch(Dispatchers.IO) {
            val data =  getMovie(TypeCategory.upComing)
            if(data.isNotEmpty()){
                listUpComing.postValue(data)
            }
        }
    }
    fun setTopRated() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getMovie(TypeCategory.topRated)
            if (data.isNotEmpty()) {
                listTopRated.postValue(data)
            }
        }
    }


    fun setCategory(option: Option){
        when(option){
            Option.japones->{
                val list = listTopRated.value?: arrayListOf()
                if(list.isNotEmpty()){
                  listRecommended.value = list.filter {
                      it.original_language=="ja"
                  }.toList()
                }
            }
            Option.years2020->{
                val list= listTopRated.value?: arrayListOf()
                if(list.isNotEmpty()){
                    listRecommended.value = list.filter {
                        it.release_date.split("-")[0]=="2020"
                    }.toList()
                }
            }
        }

    }




    }