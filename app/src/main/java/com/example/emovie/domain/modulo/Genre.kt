package com.example.emovie.domain.modulo

import com.example.emovie.data.basedato.entities.GenreEntity
import com.example.emovie.data.model.GenreModel

data class Genre (val id:Int,val name:String)

fun GenreModel.toDomain() = Genre(id,name)
fun GenreEntity.toDomain() = Genre(id,name)


