package com.chslcompany.country.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ita(
    @SerialName("common")
    val common: String,
    @SerialName("official")
    val official: String
)