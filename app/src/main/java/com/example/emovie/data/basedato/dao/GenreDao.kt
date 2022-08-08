package com.example.emovie.data.basedato.dao

import androidx.room.*
import com.example.emovie.data.basedato.entities.GenreEntity
import com.example.emovie.data.basedato.entities.MovieEntity
@Dao
interface GenreDao {

    @Query("SELECT * FROM genres")
    suspend fun getList() : List<GenreEntity>

    @Query("delete from genres")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(item: List<GenreEntity>)

    @Query("SELECT * FROM genres WHERE id IN (:ids)")
    suspend fun getListId(ids:List<Int>):List<GenreEntity>

}