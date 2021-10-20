package com.example.dhc.service.response

import com.example.dhc.model.Component
import com.google.gson.annotations.SerializedName

data class SetOrderResponse(
    @SerializedName("orderId") val orderId: String
)
