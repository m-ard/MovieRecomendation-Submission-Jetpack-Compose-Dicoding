package com.latihan.ardab.submissionjetpackcompose.model

import java.io.Serializable

data class Movie(
    val id : String,
    val title: String,
    val photo: Int,
    val description: String
): Serializable
