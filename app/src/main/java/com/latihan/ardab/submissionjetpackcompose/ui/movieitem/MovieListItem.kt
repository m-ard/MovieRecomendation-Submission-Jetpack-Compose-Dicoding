package com.latihan.ardab.submissionjetpackcompose.ui.movieitem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.latihan.ardab.submissionjetpackcompose.R
import com.latihan.ardab.submissionjetpackcompose.model.Movie

@Composable
fun MovieListItem(movies: Movie, navigateToDetail: (Movie) -> Unit ){
    Card (
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
    ){
        Row(
            Modifier.clickable{navigateToDetail(movies)}
        ) {
            Column {
                AsyncImage(
                    model = movies.photo,
                    contentDescription = stringResource(R.string.cover_movie),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(84.dp, 120.dp)
                        .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
                )
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = movies.title)
            }
        }
    }
}