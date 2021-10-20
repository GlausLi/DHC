package com.example.dhc.service.response

import com.example.dhc.model.Component
import com.google.gson.annotations.SerializedName

data class RegisterCounselingResultResponse(
    @SerializedName("counseling_result_id") val counselingResultId: Int?
)
