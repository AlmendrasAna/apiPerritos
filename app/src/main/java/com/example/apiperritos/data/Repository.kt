package com.example.apiperritos.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.apiperritos.data.local.DogBreedsDao
import com.example.apiperritos.data.local.DogBreedsEntity
import com.example.apiperritos.data.local.DogBreedsImagesEntity
import com.example.apiperritos.data.remoto.DogBreedsApi
import com.example.apiperritos.data.remoto.toBreedEntity
import com.example.apiperritos.data.remoto.toEntity

class Repository(private val dogBreedsApi: DogBreedsApi, private val dogBreedsDao: DogBreedsDao) {


    fun getListGetBreeds(): LiveData<List<DogBreedsEntity>> = dogBreedsDao.getAllBreeds()

    suspend fun getBreeds() {
        val response = dogBreedsApi.getData()
        if (response.isSuccessful) {
            val message = response.body()!!.message
            val keys = message.keys
            keys.forEach {breed->
                val dogBreedsEntity = breed.toBreedEntity()
                dogBreedsDao.insertOneBreeds(dogBreedsEntity)

            }

        }else{
            Log.e("repo",response.errorBody().toString())
        }
    }
    fun getListImaDog(id: String): LiveData<List<DogBreedsImagesEntity>> = dogBreedsDao.getAllImaBreeds(id)

    suspend fun getImaBreeds(id : String) {
        val response = dogBreedsApi.getDataIma(id)
        Log.e("repo",id)
        if (response.isSuccessful) {
            response.body()!!.message.forEach{url->
                val dogBreedsImagesEntity = url.toEntity(id)
                dogBreedsDao.insertImaBreeds(dogBreedsImagesEntity)

            }

        }else{
            Log.e("repo",response.errorBody().toString())
        }
    }

}
