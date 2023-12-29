package com.latihan.ardab.submissionjetpackcompose.ui.screen

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.latihan.ardab.submissionjetpackcompose.R
import com.latihan.ardab.submissionjetpackcompose.model.Movie



@Composable
fun DetailScreen(movies: Movie){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState).fillMaxSize()) {
        BoxWithConstraints {
            Surface {
                Column(modifier = Modifier.fillMaxSize()) {
                    DetailHeader(movies = movies, containerHeight = this@BoxWithConstraints.maxHeight)
                    DetailContent(movies = movies)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailHeader(movies: Movie, containerHeight: Dp){
    TopAppBar(
        title = { Text(text = stringResource(R.string.title_activity_detail)) },
    )
    AsyncImage(
        model = movies.photo,
        contentDescription = stringResource(R.string.cover_movie),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .padding(12.dp)
            .fillMaxWidth()
    )
}

@Composable
private fun DetailContent(movies: Movie){
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = movies.title, style = MaterialTheme.typography.titleLarge)
        }
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = movies.description,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Justify
            )
        }
    }
}