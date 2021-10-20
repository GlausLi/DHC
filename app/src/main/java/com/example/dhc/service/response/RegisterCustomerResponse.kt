package com.example.dhc.service.response

import com.example.dhc.model.Component
import com.google.gson.annotations.SerializedName

data class RegisterCustomerResponse(
    @SerializedName("customer_uuid") val uuid: String?
)
