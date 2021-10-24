package com.chslcompany.country.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Idd(
    @SerialName("root")
    val root: String,
    @SerialName("suffixes")
    val suffixes: List<String>
)