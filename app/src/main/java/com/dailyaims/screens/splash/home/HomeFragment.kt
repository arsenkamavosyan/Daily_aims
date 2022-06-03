package com.dailyaims.screens.splash.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dailyaims.Aims
import com.dailyaims.databinding.FragmentHomeBinding
import com.dailyaims.screens.splash.recycler_view_adapter.AimsAdapter

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val aimsAdapter = AimsAdapter()

    private var index = 0


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
            if (index > 10) index = 0
            val aims = Aims(title = "Title $index")
            aimsAdapter.addAims(aims)
            index++
        }
    }
}