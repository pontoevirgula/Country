package com.chslcompany.country.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Demonyms(
    @SerialName("eng")
    val eng: Eng
)