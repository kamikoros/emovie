package com.example.emovie.ui.internal

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emovie.domain.GetDetailMovie
import com.example.emovie.domain.GetListVideo
import com.example.emovie.domain.modulo.Genre
import com.example.emovie.domain.modulo.Movie
import com.example.emovie.domain.modulo.Video
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class InternalViewModel @Inject constructor(private val getDetail:GetDetailMovie,private val getVideo: GetListVideo):ViewModel() {
    var detail = MutableLiveData<Movie>()
    var video  = MutableLiveData<Video>()
    var id =0
    fun init(bundle: Bundle?){
        if(bundle != null){
            id =bundle.getInt("id",0)
            getData(id = id )
        }
    }


    fun getData(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            val data = getDetail(id)
            if(data!=null){
                detail.postValue(data)
            }
        }
    }

    fun txtGenres(data:List<Genre>):String{
        var txt = ""
         data.takeLast(4).forEach {
            txt+="  ${it.name}  *"
         }
        return if (txt.isNotBlank()) txt.dropLast(1) else ""
    }


    fun uploadVideo(){
        viewModelScope.launch(Dispatchers.IO) {
            val listVideo  = getVideo(id)
            if(listVideo.isNotEmpty()){
               video.postValue(listVideo.first())
            }
        }

    }




}