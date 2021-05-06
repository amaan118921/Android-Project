package com.example.movietrackers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.movietrackers.adapter.TopRatedApadter
import com.example.movietrackers.databinding.FragmentTopRatedBinding
import com.example.movietrackers.model.TopRatedViewModel


class TopRatedFragment : Fragment() {
   private val viewModel: TopRatedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTopRatedBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.topRatedRecyclerView.adapter = TopRatedApadter(this.requireContext())
        binding.nextPage.setOnClickListener {
            viewModel.pageNo += 1
            viewModel.getTopRated()
        }
        binding.previousPage.setOnClickListener {
            if(viewModel.pageNo==1)
            {
                val action = TopRatedFragmentDirections.actionTopRatedFragmentToHomeFragment()
                binding.previousPage.findNavController().navigate(action)
            }
            else
            {
                viewModel.pageNo -= 1
                viewModel.getTopRated()
            }
        }
        return binding.root
    }


}