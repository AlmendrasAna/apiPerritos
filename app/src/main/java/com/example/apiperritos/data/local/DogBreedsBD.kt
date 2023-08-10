package com.example.apiperritos.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DogBreedsEntity::class,DogBreedsImagesEntity::class], version = 1)
abstract class DogBreedsBD() : RoomDatabase() {

    abstract fun getDaoDogBreeds (): DogBreedsDao

    companion object {
        @Volatile
        private var INSTANCE: DogBreedsBD? = null

        fun getDatabase(context: Context): DogBreedsBD {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DogBreedsBD::class.java,
                    "breed_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}