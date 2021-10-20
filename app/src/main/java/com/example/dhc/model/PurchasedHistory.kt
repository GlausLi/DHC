package com.example.dhc.model

import com.google.gson.annotations.SerializedName

class PurchasedHistory (
    @SerializedName("uuid") val date: String,
    @SerializedName("description") val description: String
)
