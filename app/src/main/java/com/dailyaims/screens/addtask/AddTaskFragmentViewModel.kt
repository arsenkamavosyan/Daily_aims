package com.dailyaims.screens.addtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dailyaims.REPOSITORY
import com.dailyaims.model.AimsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddTaskFragmentViewModel : ViewModel() {

    fun insert(aimsModel: AimsModel, OnSucces: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertAims(aimsModel) {
                OnSucces()
            }
        }
}