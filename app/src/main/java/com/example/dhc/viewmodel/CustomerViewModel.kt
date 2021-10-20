package com.example.dhc.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dhc.model.Component
import com.example.dhc.service.ApiHelper
import com.example.dhc.service.Result
import kotlinx.coroutines.launch

class CustomerViewModel : ViewModel(){
    val customerUuid : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val errorMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun registerCustomer(uuid:String, nickname:String) {
        viewModelScope.launch {
            val response = ApiHelper.registerCustomer(uuid, nickname)
            when (response) {
                is Result.Success -> {
                    customerUuid.postValue(response.data.uuid)
                }
                is Result.Error -> {
                    errorMessage.postValue(response.exception)
                }
            }
        }
    }
}