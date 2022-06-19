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
import com.dailyaims.model.AimType
import com.dailyaims.model.AimsModel
import java.util.*


class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private lateinit var viewModel: AddTaskFragmentViewModel

    private var isEdit: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTaskBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddTaskFragmentViewModel::class.java)
        val aimsModel = arguments?.getSerializable(ARGUMENT_KEY) as? AimsModel
        isEdit = aimsModel != null
        if (isEdit) {
            binding.btnCreate.text = getString(R.string.edit)
            binding.tiName.editText?.setText(aimsModel?.name)
            binding.tiMiavor.editText?.setText(aimsModel?.type ?: "")
            binding.tiDayplan.editText?.setText(aimsModel?.dayPLan)
            binding.checkboxReplay.isChecked = aimsModel?.isReplay ?: false
            binding.checkboxNotifications.isChecked = aimsModel?.isNotification ?: false
        }

        val type = AimType.values().map { it.value }
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            R.layout.dropdown_menu_popup_item,
            type
        )

        val editTextFilledExposedDropdown: AutoCompleteTextView =
            view.findViewById(R.id.filled_exposed_dropdown)
        editTextFilledExposedDropdown.setAdapter(adapter)

        binding.btnCreate.setOnClickListener {
            val id = if (isEdit) {
                aimsModel?.id ?: "" // ete hin modeln a
            } else {
                UUID.randomUUID().toString() // ete nor model a
            }

            val model = AimsModel(
                id = id,
                name = binding.tiName.editText?.text.toString(),
                type = binding.filledExposedDropdown.text.toString(),
                dayPLan = binding.tiDayplan.editText?.text.toString(),
                isReplay = binding.checkboxReplay.isChecked,
                isNotification = binding.checkboxNotifications.isChecked
            )
            viewModel.insert(model) {}
            findNavController().popBackStack()
        }
    }

    companion object {
        const val ARGUMENT_KEY = "ARGUMENT_KEY"
    }
}