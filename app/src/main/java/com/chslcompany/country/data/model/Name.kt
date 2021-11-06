package com.chslcompany.country.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Name(
    @SerialName("common")
    val common: String,
    @SerialName("nativeName")
    val nativeName: NativeName,
    @SerialName("official")
    val official: String
)