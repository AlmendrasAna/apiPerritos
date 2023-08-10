package com.example.apiperritos.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("tabla_raza")
data class DogBreedsEntity(@PrimaryKey val breeds: String)


@Entity("tabla_ima_raza", primaryKeys = ["breeds", "url"])
data class DogBreedsImagesEntity(val breeds: String, val url: String)
