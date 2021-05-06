package com.example.movietrackers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.movietrackers.adapter.RecyclerViewAdapter
import com.example.movietrackers.databinding.FragmentTVShowBinding
import com.example.movietrackers.model.TVShowViewModel


class TVShowFragment : Fragment() {

    private val viewModel: TVShowViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTVShowBinding.inflate(inflater)
            binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.recyclerView.adapter = RecyclerViewAdapter(this.requireContext())
        binding.nextPage.setOnClickListener {
            viewModel.pageNo += 1
            viewModel.getShows()
        }
        binding.previousPage.setOnClickListener {
            if(viewModel.pageNo==1)
            {
                val action = TVShowFragmentDirections.actionTVShowFragmentToHomeFragment()
                binding.previousPage.findNavController().navigate(action)
            }
            else
            {
                viewModel.pageNo -= 1
                viewModel.getShows()

            }
        }
        return binding.root
    }








}