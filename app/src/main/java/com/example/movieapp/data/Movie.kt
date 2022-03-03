package com.example.movieapp.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

//https://developers.themoviedb.org/3/discover/movie-discover
//https://api.themoviedb.org/3/discover/movie?api_key=fd2e2649af1655e26b1049940615a98b
// &language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1
@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey
    val imdbID: Long,
    @ColumnInfo(name = "Title")
    val Title: String,

    @ColumnInfo(name = "Poster")
    val Poster: String,

    @ColumnInfo(name = "Year")
    val Year: Long,
    @ColumnInfo(name = "Released")
    @SerializedName("Released")
    val Released: Date,


    val Description: String,
    val Actors: String,
    val Runtime: String,
    val Genre: String,
    val Director: String,
    val Writer: String,
    val Language:String,
    val Country: String,
    val Awards: String,
    val Type: String

)