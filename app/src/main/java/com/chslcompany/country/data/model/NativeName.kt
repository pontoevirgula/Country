package com.chslcompany.country.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NativeName(
    @SerialName("eng")
    val eng: EngX
)