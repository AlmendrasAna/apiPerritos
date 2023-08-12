package com.example.apiperritos.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DogBreedsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreeds(dogBreedsEntity: List<DogBreedsEntity>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneBreeds(dogBreedEntity: DogBreedsEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImaBreeds(dogBreedsImagesEntity: DogBreedsImagesEntity)
    @Query("Select * From tabla_raza order by breeds ASC ")
    fun getAllBreeds(): LiveData<List<DogBreedsEntity>>
    @Query("Select * From tabla_ima_raza where breeds like :id")
    fun getAllImaBreeds(id : String): LiveData<List<DogBreedsImagesEntity>>
}