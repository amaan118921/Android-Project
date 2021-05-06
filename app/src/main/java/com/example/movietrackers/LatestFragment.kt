package com.example.movietrackers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.movietrackers.adapter.LatestAdpater
import com.example.movietrackers.databinding.FragmentLatestBinding
import com.example.movietrackers.model.LatestViewModel


class LatestFragment : Fragment() {
    private val viewModel: LatestViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentLatestBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.latest = viewModel
        binding.latestRecyclerView.adapter = LatestAdpater(this.requireContext())
        return binding.root
    }
}