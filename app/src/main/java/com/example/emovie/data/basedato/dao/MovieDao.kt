package com.example.emovie.data.basedato.dao

import androidx.room.*
import com.example.emovie.data.basedato.entities.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies where type =:type")
    suspend fun getList(type: String) : List<MovieEntity>


    @Query("delete from movies where type =:type")
    suspend fun deleteAll(type: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(item: List<MovieEntity>)

    @Query("select * from movies where id = :id")
     suspend fun getId(id: Int):MovieEntity



}