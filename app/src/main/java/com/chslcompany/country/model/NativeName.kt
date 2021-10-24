package com.chslcompany.country.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NativeName(
    @SerialName("eng")
    val eng: EngX
)