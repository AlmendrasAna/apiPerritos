package com.example.apiperritos.data.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface DogBreedsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertBreeds(dogBreedsEntity: DogBreedsEntity)
@Query("Select * From tabla_raza orden by breeds desc")
fun getAllBreeds (): LiveData<List<DogBreedsEntity>>

}