package com.example.abdl.mymoviecatalogue.utils

import android.content.Context
import com.example.abdl.mymoviecatalogue.data.source.remote.response.MovieResponse
import com.example.abdl.mymoviecatalogue.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("FilmResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("movieId")
                val title = movie.getString("title")
                val director = movie.getString("director")
                val genre = movie.getString("genre")
                val overview = movie.getString("overview")
                val imagePath = movie.getString("image")

                val movieResponse = MovieResponse(id, title, director, genre, overview, imagePath)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShows(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("FilmResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)

                val id = tvshow.getString("tvshowId")
                val title = tvshow.getString("title")
                val creator = tvshow.getString("creator")
                val year = tvshow.getString("year")
                val overview = tvshow.getString("overview")
                val imagePath = tvshow.getString("image")

                val tvShowResponse = TvShowResponse(id, title, creator, year, overview, imagePath)
                list.add(tvShowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}