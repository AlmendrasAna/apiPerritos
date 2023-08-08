package com.example.apiperritos.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.apiperritos.data.remoto.DogBreeds

@Entity("tabla_raza")
data class DogBreedsEntity(@PrimaryKey(autoGenerate = true) val id:Long,val breeds :String)
