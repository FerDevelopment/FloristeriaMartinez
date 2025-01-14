package com.example.floristeriamartinez.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Empleado(
        @SerialName(value = "id")
        val id : Int ,
        @SerialName(value = "nombre")
        val nombre : String ,
        @SerialName(value = "puesto")
        val puesto : String ,
        @SerialName(value = "salario")
        val salario : Double ,
                   )
