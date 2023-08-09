package com.example.apiperritos.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DogBreedsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreeds(dogBreedsEntity: DogBreedsEntity)

    @Query("Select * From tabla_raza order by breeds ASC ")
    fun getAllBreeds(): LiveData<List<DogBreedsEntity>>

}