package com.example.apiperritos.data.remoto

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogBreedsApi {

    @GET("breeds/list/all")
    suspend fun getData(): Response<DogBreeds>
//se le pasa un id q es variable para q muestre solo algunas razas de perro

    @GET("breed/{id}/images")

    suspend fun getDataIma(@Path("id") id: String): Response<DogBreedsImages>

}