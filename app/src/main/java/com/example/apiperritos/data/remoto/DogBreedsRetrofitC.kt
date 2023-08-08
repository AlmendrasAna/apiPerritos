package com.example.apiperritos.data.remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogBreedsRetrofitC {
    companion object {

        private const val URL_BASE = "https://dog.ceo/api/"

        fun getRetrofitDogBreeds(): DogBreedsApi {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return mRetrofit.create(DogBreedsApi::class.java)

        }
    }
}