package com.example.apiperritos.view.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.apiperritos.R
import com.example.apiperritos.databinding.FragmentRecyclerBinding
import com.example.apiperritos.view.DogBreedsVM

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerFragment : Fragment() {
    lateinit var binding: FragmentRecyclerBinding
    private val dogBreedsVM: DogBreedsVM by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false)

        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = Adapter()
        binding.recyclerView.adapter = adapter
        dogBreedsVM.getAllRazas()
        dogBreedsVM.getLiveDataAllBreeds().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}


