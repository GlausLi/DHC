package com.example.dhc.service.response

import com.example.dhc.model.Counseling
import com.google.gson.annotations.SerializedName

data class GetCounselingResponse(
    @SerializedName("counselingInfo") val components: Counseling?
)
