package com.example.movietrackers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.movietrackers.adapter.HomeAdapter
import com.example.movietrackers.databinding.FragmentHomeBinding
import com.example.movietrackers.model.HomeViewModel


class HomeFragment : Fragment() {
    val viewModel: HomeViewModel by viewModels()

    private var _binding : FragmentHomeBinding? = null
         private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel =viewModel
        binding.homeRecyclerView.adapter = HomeAdapter(this.requireContext())
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvShowHome.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTVShowFragment2()
            binding.tvShowHome.findNavController().navigate(action)
        }
        binding.topRatedHome.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTopRatedFragment()
            binding.topRatedHome.findNavController().navigate(action)
        }
        binding.popularHome.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToPopularFragment()
            binding.popularHome.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}