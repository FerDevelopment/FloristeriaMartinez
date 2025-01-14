package com.example.floristeriamartinez.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import java.util.Date
@Serializable
data class FloresMarchitadas(
        @SerialName(value = "id")
        val id : Int ,
        @SerialName(value = "tipoFlores")
        val tipoFlores : Int ,
        @SerialName(value = "fecha")
        val fecha : String ,
        @SerialName(value = "razon")
        val razon : String
                            )
