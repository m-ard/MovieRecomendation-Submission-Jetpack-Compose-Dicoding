package com.latihan.ardab.submissionjetpackcompose.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.latihan.ardab.submissionjetpackcompose.model.Movie
import com.latihan.ardab.submissionjetpackcompose.ui.screen.DetailScreen
import com.latihan.ardab.submissionjetpackcompose.ui.theme.MovieTimeTheme


class DetailActivity : ComponentActivity() {
    private val movies: Movie by lazy { intent?.getSerializableExtra(MOVIE_ID) as Movie }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTimeTheme {
                DetailScreen(movies = movies)
            }
        }
    }

    companion object{
        private const val MOVIE_ID = "ID"
        fun newIntent(context: Context, movies: Movie)= Intent(context, DetailActivity::class.java).apply {
            putExtra(MOVIE_ID, movies)
        }
    }
}
