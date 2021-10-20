package com.example.dhc.service.response

import com.example.dhc.model.Component
import com.google.gson.annotations.SerializedName

data class RegisterMedicalResultResponse(
    @SerializedName("medical_result_id") val components:Int
)
