package com.example.floristeriamartinez.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cliente(
        @SerialName(value = "id")
        val id : Int ,
        @SerialName(value = "nombre")
        val nombre : String ,
        @SerialName(value = "email")
        val email : String ,
        @SerialName(value = "telefono")
        val telefono : String
                  )
