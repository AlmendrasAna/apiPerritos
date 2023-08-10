package com.example.apiperritos.data.remoto

data class DogBreeds(
    val message: Map<String, List<String>>,
    val status: String
)

data class DogBreedsImages(val status: String, val message: List<String>)
