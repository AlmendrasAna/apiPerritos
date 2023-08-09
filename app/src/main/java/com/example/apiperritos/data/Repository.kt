package com.example.apiperritos.data

import com.example.apiperritos.data.local.DogBreedsDao
import com.example.apiperritos.data.local.DogBreedsEntity
import com.example.apiperritos.data.remoto.DogBreedsApi

class Repository(private val dogBreedsApi: DogBreedsApi, private val dogBreedsDao: DogBreedsDao) {




    suspend fun getBreeds() {
        val response = dogBreedsApi.getData()
        if (response.isSuccessful) {
            val message = response.body()!!.message
            val keys = message.keys
            keys.forEach {
                val dogBreedsEntity = DogBreedsEntity(it)
                dogBreedsDao.insertBreeds(dogBreedsEntity)

            }

        }
    }



}
