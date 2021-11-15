package com.example.testsecondtry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testsecondtry.adaptors.RVAdapterFav
import com.example.testsecondtry.model.MyViewModel

class FavoriteFragment : Fragment() {

    lateinit var viewModel: MyViewModel
    lateinit var rvAdapter: RVAdapterFav
    lateinit var rvFav: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        rvFav = view.findViewById(R.id.rvFav)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.getPhotos().observe(
            viewLifecycleOwner,
            { show ->
                rvAdapter.update(show)
            }
        )
        updateRV()

        return view
    }
    fun updateRV(){
        rvAdapter = RVAdapterFav(this)
        rvFav.adapter = rvAdapter
        rvFav.layoutManager = LinearLayoutManager(requireContext())

    }

}