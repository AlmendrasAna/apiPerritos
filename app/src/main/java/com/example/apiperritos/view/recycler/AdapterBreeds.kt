package com.example.apiperritos.view.recycler

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.apiperritos.R
import com.example.apiperritos.data.local.DogBreedsEntity
import com.example.apiperritos.databinding.ItemBinding

class AdapterBreeds : RecyclerView.Adapter<AdapterBreeds.ViewHolder>() {


    private var dogBreedsEntitys: List<DogBreedsEntity> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dogBreedsEntitys.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dogBreedsEntity = dogBreedsEntitys[position]
        holder.bind(dogBreedsEntity)
    }

    fun setData(dogBreedsEntitys: List<DogBreedsEntity>) {

        this.dogBreedsEntitys = dogBreedsEntitys

        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dogBreedsEntity: DogBreedsEntity) {


            binding.razaTxt.text = dogBreedsEntity.breeds.uppercase()
            binding.cardItem.setOnClickListener{
                val bundle = Bundle()
                bundle.putString("breeds",binding.razaTxt.text.toString().lowercase())
                Log.e("lol",bundle.toString())
                Navigation.findNavController(binding.root).navigate(R.id.action_recyclerFragment_to_infoFragment,bundle)
            }

        }

    }


}