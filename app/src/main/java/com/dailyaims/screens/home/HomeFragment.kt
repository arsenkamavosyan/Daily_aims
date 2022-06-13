package com.dailyaims.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dailyaims.R
import com.dailyaims.adapter.recycler_view_adapter.AimsAdapter
import com.dailyaims.adapter.recycler_view_adapter.EventListener
import com.dailyaims.databinding.FragmentHomeBinding
import com.dailyaims.model.AimsModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        val viewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        viewModel.initDataBase()
        binding.btnFab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addTaskFragment)
        }
        val aimsAdapter = AimsAdapter(object : EventListener {
            override fun onItemClicked(aims: AimsModel) {
                clickAims(aims)
            }
        })
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            hasFixedSize()
            adapter = aimsAdapter
        }
        viewModel.getAllAims().observe(viewLifecycleOwner) { listAims ->
            aimsAdapter.setList(listAims)
        }
        return binding.root
    }

    private fun clickAims(aimsModel: AimsModel) {
        val bundle = Bundle()
        bundle.putSerializable("Aims", aimsModel)
        findNavController().navigate(R.id.action_homeFragment_to_addTaskFragment)
    }
}