package com.example.apiperritos.data.remoto

data class DogBreeds(    val message: Map<String, List<String>>,
                         val status: String
)
data class BreedImagesDog(val status: String, val message: List<String>)
