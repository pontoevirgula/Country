package com.chslcompany.country.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Eng(
    @SerialName("f")
    val f: String,
    @SerialName("m")
    val m: String
)