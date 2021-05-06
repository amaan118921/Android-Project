package com.example.movietrackers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.movietrackers.adapter.PopularAdapter
import com.example.movietrackers.databinding.FragmentPopularBinding
import com.example.movietrackers.model.PopularViewModel


class PopularFragment : Fragment() {
private val viewModel: PopularViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPopularBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.popularRecyclerView.adapter = PopularAdapter(this.requireContext())
        binding.nextPage.setOnClickListener {
            viewModel.pageNo += 1
            viewModel.getPopular()
        }
        binding.previousPage.setOnClickListener {
            if(viewModel.pageNo==1)
            {
                val action = PopularFragmentDirections.actionPopularFragmentToHomeFragment()
                binding.previousPage.findNavController().navigate(action)
            }
            else{
                viewModel.pageNo -= 1
                viewModel.getPopular()
            }

           
        }
        return binding.root
    }

}