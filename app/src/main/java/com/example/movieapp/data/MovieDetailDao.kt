package com.example.movieapp.data
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface MovieDetailDao {
    @Query("SELECT * FROM movie WHERE `imdbID` = :id")
    fun getMovie(id: Long): LiveData<Movie>
}