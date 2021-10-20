package com.example.dhc.service.response

import com.example.dhc.model.Component
import com.google.gson.annotations.SerializedName

data class GetComponentResponse(
    @SerializedName("components") val components: List<Component>?
)
