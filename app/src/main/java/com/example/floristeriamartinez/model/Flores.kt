package com.example.floristeriamartinez.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Flores(
        @SerialName(value = "id")
        val id : Int ,
        @SerialName(value = "nombre")
        val nombre : String ,
        @SerialName(value = "tipoFlores")
        val tipoFlores : Int ,
        @SerialName(value = "precio")
        val precio : Double
                 )