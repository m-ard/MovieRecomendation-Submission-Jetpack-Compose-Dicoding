package com.latihan.ardab.submissionjetpackcompose.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.latihan.ardab.submissionjetpackcompose.R
import com.latihan.ardab.submissionjetpackcompose.model.Movie
import com.latihan.ardab.submissionjetpackcompose.ui.movieitem.MovieContent
import com.latihan.ardab.submissionjetpackcompose.ui.theme.MovieTimeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTimeTheme {
                MyMovieApp{
                    startActivity(DetailActivity.newIntent(this, it))
                }
            }

        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyMovieApp(navigateToDetail: (Movie) -> Unit){
    Scaffold (
        content = {
            MovieContent(navigateToDetail = navigateToDetail)
            OptionMenu()
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionMenu(){
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = stringResource(R.string.home)) },
        actions = {
            IconButton(onClick = { context.startActivity(Intent(context, AboutActivity::class.java)) }) {
                Icon(Icons.Default.AccountCircle, contentDescription = stringResource(R.string.ic_about))
            }
        }
    )
}