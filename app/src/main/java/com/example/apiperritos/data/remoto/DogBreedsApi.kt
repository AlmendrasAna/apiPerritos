package com.example.apiperritos.data.remoto

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogBreedsApi {

    @GET("breeds/list/all")
    suspend fun getData(): Response<DogBreeds>

    @GET("breeds/{id}/imagenes")
    //se le pasa un id q es variable para q muestre solo algunas razas de perro

    suspend fun getDataIma(@Path("id") id: String): Response<DogBreedsImages>

}