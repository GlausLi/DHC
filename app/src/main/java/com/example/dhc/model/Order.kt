package com.example.dhc.model

import com.google.gson.annotations.SerializedName

class Order (
    @SerializedName("uuid") val id: String,
    @SerializedName("uuid") val uuid: String,
    @SerializedName("componentId") val componentId: String,
    @SerializedName("componentId2") val componentId2: String,
    @SerializedName("componentId3") val componentId3: String,
    @SerializedName("componentId4") val componentId4: String,
    @SerializedName("componentId5") val componentId5: String,
    @SerializedName("componentId6") val componentId6: String,
    @SerializedName("componentId7") val componentId7: String,
    @SerializedName("componentId8") val componentId8: String,
    @SerializedName("componentId9") val componentId9: String
)
