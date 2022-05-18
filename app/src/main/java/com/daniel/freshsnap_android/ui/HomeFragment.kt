package com.daniel.freshsnap_android.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.daniel.freshsnap_android.*
import com.daniel.freshsnap_android.databinding.FragmentFirstBinding


class HomeFragment : Fragment() {

    private var binding : FragmentFirstBinding? = null

    private val list_fruit = ArrayList<Fruits>()
    private val list_vegetable = ArrayList<Vegetables>()

    private val _binding get() = binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        list_fruit.addAll(listFruits)

        list_vegetable.addAll(listVegetables)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return _binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.fruitsRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        _binding.vegetablesRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        _binding.fruitsRecyclerview.setHasFixedSize(true)
        _binding.vegetablesRecyclerview.setHasFixedSize(true)

        showRecyclerListFruit()
        showRecyclerListVegetables()

    }

    private val listFruits: ArrayList<Fruits>
        @SuppressLint("Recycle")
        get() {
            val dataNameFruit = resources.getStringArray(R.array.data_fruits_name)
            val dataPhotoFruit = resources.obtainTypedArray(R.array.data_photo_fruits)
            val listFruit = ArrayList<Fruits>()
            for (i in dataNameFruit.indices) {
                val fruit = Fruits(dataNameFruit[i], dataPhotoFruit.getResourceId(i, -1))
                listFruit.add(fruit)
            }
            return listFruit
        }

    private fun showRecyclerListFruit() {
        val listFruitAdapter = ListFruitAdapter(list_fruit)
        _binding.fruitsRecyclerview.adapter = listFruitAdapter
    }

    private val listVegetables: ArrayList<Vegetables>
        @SuppressLint("Recycle")
        get() {
            val dataNameVegetable = resources.getStringArray(R.array.data_vegetables_name)
            val dataPhotoVegetable = resources.obtainTypedArray(R.array.data_photo_vegetables)
            val listVegetable = ArrayList<Vegetables>()
            for (i in dataNameVegetable.indices) {
                val vegetable = Vegetables(dataNameVegetable[i], dataPhotoVegetable.getResourceId(i, -1))
                listVegetable.add(vegetable)
            }
            return listVegetable
        }

    private fun showRecyclerListVegetables() {
        val listVegetableAdapter = ListVegetableAdapter(list_vegetable)
        _binding.vegetablesRecyclerview.adapter = listVegetableAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}