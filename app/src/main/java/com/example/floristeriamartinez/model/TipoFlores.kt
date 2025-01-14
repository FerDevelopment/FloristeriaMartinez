package com.example.floristeriamartinez.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TipoFlores(
        @SerialName(value = "id")
        val id : Int ,
        @SerialName(value = "tipo")
        val tipo : String
                     )
