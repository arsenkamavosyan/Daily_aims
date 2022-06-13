package com.dailyaims.screens.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dailyaims.REPOSITORY
import com.dailyaims.database.AimsDataBase
import com.dailyaims.database.repository.AimsRealization
import com.dailyaims.model.AimsModel

class HomeFragmentViewModel(application: Application) :AndroidViewModel(application){
    val context = application

    fun initDataBase(){
        val daoAims = AimsDataBase.getInstanse(context).getAimsDao()
        REPOSITORY = AimsRealization(daoAims)
    }
    fun getAllAims():LiveData<List<AimsModel>>{
        return REPOSITORY.allAims
    }
}