package com.example.dhc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dhc.model.Component
import com.example.dhc.service.ApiHelper
import com.example.dhc.service.Result
import kotlinx.coroutines.launch

class ComponentViewModel : ViewModel(){
    val components : MutableLiveData<List<Component>> by lazy {
        MutableLiveData<List<Component>>()
    }

    val errorMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getCompoment() {
        viewModelScope.launch {
            val response = ApiHelper.getComponent()
            when (response) {
                is Result.Success -> {
                    components.postValue(response.data.components)
                }
                is Result.Error -> {
                    errorMessage.postValue(response.exception)
                }
            }
        }
    }
}