package com.dailyaims.screens.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dailyaims.R
import com.dailyaims.databinding.FragmentAddTaskBinding
import com.dailyaims.model.AimsModel


class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTaskBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(AddTaskFragmentViewModel::class.java)

        val type = arrayOf("hat", "km", "metr", "rope", "jam")

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            R.layout.dropdown_menu_popup_item,
            type
        )

        val editTextFilledExposedDropdown: AutoCompleteTextView =
            view.findViewById(R.id.filled_exposed_dropdown)
        editTextFilledExposedDropdown.setAdapter(adapter)

        binding.btnCreate.setOnClickListener {
            val title1 = binding.tiName.editText?.text.toString()
            val dayPlan = binding.tiDayplan.editText?.text.toString()
            viewModel.insert(AimsModel(title = title1, description = dayPlan)) {}
            findNavController().popBackStack()
        }
    }
}