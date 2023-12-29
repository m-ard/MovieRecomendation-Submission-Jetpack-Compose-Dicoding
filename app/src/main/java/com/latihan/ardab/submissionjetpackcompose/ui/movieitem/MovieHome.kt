package com.latihan.ardab.submissionjetpackcompose.ui.movieitem

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.latihan.ardab.submissionjetpackcompose.model.Movie
import com.latihan.ardab.submissionjetpackcompose.model.MovieData

@Composable
fun MovieContent(navigateToDetail: (Movie) -> Unit){
    val movies = remember {
        MovieData.movies
    }
    LazyColumn(contentPadding = PaddingValues(horizontal = 8.dp, vertical = 64.dp) ){
        items(
            items = movies,
            itemContent = {
                MovieListItem(movies = it, navigateToDetail)
            }
        )
    }
}