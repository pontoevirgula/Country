package com.chslcompany.country.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Translations(
    @SerialName("ara")
    val ara: Ara,
    @SerialName("ces")
    val ces: Ces,
    @SerialName("cym")
    val cym: Cym,
    @SerialName("deu")
    val deu: Deu,
    @SerialName("est")
    val est: Est,
    @SerialName("fin")
    val fin: Fin,
    @SerialName("fra")
    val fra: Fra,
    @SerialName("hrv")
    val hrv: Hrv,
    @SerialName("hun")
    val hun: Hun,
    @SerialName("ita")
    val ita: Ita,
    @SerialName("jpn")
    val jpn: Jpn,
    @SerialName("kor")
    val kor: Kor,
    @SerialName("nld")
    val nld: Nld,
    @SerialName("per")
    val per: Per,
    @SerialName("pol")
    val pol: Pol,
    @SerialName("por")
    val por: Por,
    @SerialName("rus")
    val rus: Rus,
    @SerialName("slk")
    val slk: Slk,
    @SerialName("spa")
    val spa: Spa,
    @SerialName("swe")
    val swe: Swe,
    @SerialName("urd")
    val urd: Urd,
    @SerialName("zho")
    val zho: Zho
)