package com.example.apiperritos.data.remoto

import com.example.apiperritos.data.local.DogBreedsEntity
import com.example.apiperritos.data.local.DogBreedsImagesEntity

fun String.toBreedEntity(): DogBreedsEntity= DogBreedsEntity(this)

fun String.toEntity(id : String): DogBreedsImagesEntity = DogBreedsImagesEntity(id,this)