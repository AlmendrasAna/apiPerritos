package com.example.apiperritos.data.remoto

import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun toEntity() {

        //given, Dado este valor

        val url = "http://federico.com"
        val id = "datoID"

        //when, hago esta accion

        val resultado = url.toEntity(id)

        //then,  deberia dar este resultado

        assertEquals(id,resultado.breeds)
        assertEquals(url,resultado.url)

    }

    @Test
    fun toBreedEntity() {
        //given, Dado este valor

             val id = "akita"

        //when, hago esta accion

        val resultado = id.toBreedEntity()

        //then,  deberia dar este resultado

        assertEquals(id,resultado.breeds)
    }
}