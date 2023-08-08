package com.example.apiperritos.data.remoto

import retrofit2.Response
import retrofit2.http.GET

interface DogBreedsApi {

    @GET("breeds/list/all")
    suspend fun getData() : Response<DogBreeds>


}