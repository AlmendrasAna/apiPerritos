package com.example.apiperritos.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiperritos.data.Repository
import com.example.apiperritos.data.local.DogBreedsBD
import com.example.apiperritos.data.remoto.DogBreedsRetrofitC
import kotlinx.coroutines.launch

class DogBreedsVM(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repository

    init {
        val api = DogBreedsRetrofitC.getRetrofitDogBreeds()
        val razaDatabase = DogBreedsBD.getDatabase(application).getDaoDogBreeds()
        repositorio = Repository(api, razaDatabase)
    }

    fun getLiveDataAllBreeds() = repositorio.getListGetBreeds()


    fun getAllRazas() = viewModelScope.launch {
        repositorio.getBreeds()
    }
    fun getLiveDataAllImaBreeds(id :String) = repositorio.getListImaDog(id)

    fun getImaBreeds(id : String) = viewModelScope.launch {
        repositorio.getImaBreeds(id)
    }

}