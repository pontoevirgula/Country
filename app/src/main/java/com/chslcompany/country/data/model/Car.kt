package com.chslcompany.country.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Car(
    @SerialName("side")
    val side: String,
    @SerialName("signs")
    val signs: List<String>
)