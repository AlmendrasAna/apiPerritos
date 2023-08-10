package com.example.apiperritos.view.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apiperritos.R
import com.example.apiperritos.data.local.DogBreedsImagesEntity
import com.example.apiperritos.databinding.ItemImaBinding

class AdapterInfoIma  : RecyclerView.Adapter<AdapterInfoIma.ViewHolder>() {


    private var imasBreeds: List<DogBreedsImagesEntity> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemImaBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imasBreeds.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imaEntity = imasBreeds[position]
        holder.bind(imaEntity)
    }

    fun setData(dogBreedsEntitys: List<DogBreedsImagesEntity>) {

        this.imasBreeds = dogBreedsEntitys

        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ItemImaBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(imaEntity: DogBreedsImagesEntity) {

            binding.imageDog.load(imaEntity.url){    crossfade(true)
                placeholder(R.drawable.dog_log)
            }
        }

    }


}