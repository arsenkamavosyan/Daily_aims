package com.dailyaims.screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dailyaims.Aims
import com.dailyaims.R
import com.dailyaims.databinding.FragmentHomeBinding
import com.dailyaims.screens.recycler_view_adapter.AimsAdapter

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val aimsAdapter = AimsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() = with(binding) {
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = aimsAdapter
        btnFab.setOnClickListener {
           findNavController().navigate(R.id.action_homeFragment_to_addTaskFragment)
        }
    }
}