package com.example.emovie.data.basedato.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.emovie.domain.modulo.Genre

@Entity(tableName = "genres")
data class GenreEntity (
    @PrimaryKey
    @ColumnInfo(name="id")
    val id: Int,
    @ColumnInfo(name ="name")
    val name: String,
 )

fun Genre.toDataBase() = GenreEntity(id,name)



