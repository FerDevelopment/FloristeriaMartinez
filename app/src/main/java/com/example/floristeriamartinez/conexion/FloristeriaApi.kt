package com.example.floristeriamartinez.conexion

import com.example.floristeriamartinez.model.Cliente
import com.example.floristeriamartinez.model.Empleado
import com.example.floristeriamartinez.model.Flores
import com.example.floristeriamartinez.model.FloresMarchitadas
import com.example.floristeriamartinez.model.TipoFlores
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

/*Aqui van TODOS los metodos para obtener cosas de la base de datos. TODOS*/
interface FloristeriaApi {
   /*----------------GETS----------------*/
   @GET("clientes")
   suspend fun obtenerClientes(): List<Cliente>

   @GET("flores")
   suspend fun obtenerFlores(): List<Flores>

   @GET("empleados")
   suspend fun obtenerEmpleados(): List<Empleado>

   @GET("tipo_flores")
   suspend fun obtenerTiposFlores(): List<TipoFlores>

   @GET("flores_marchitadas")
   suspend fun obtenerFloresMarchitadas(): List<FloresMarchitadas>

   /*----------------POSTS----------------*/
   @POST("clientes")
   suspend fun insertarClientes(
      @Body
      cliente: Cliente
   ): Cliente

   @POST("flores")
   suspend fun insertarFlores(
      @Body
      flor: Flores
   ): Flores

   @POST("empleados")
   suspend fun insertarEmpleado(
      @Body
      empleado: Empleado
   ): Empleado

   @POST("tipo_flores")
   suspend fun insertarTiposFlores(
      @Body
      tipoFlores: TipoFlores
   ): TipoFlores

   @POST("flores_marchitadas")
   suspend fun insertarFloresMarchitadas(
      @Body
      floresMarchitadas: FloresMarchitadas
   ): FloresMarchitadas

   /*----------------Updates----------------*/
   @PUT("clientes/{id}")
   suspend fun actualizarClientes(
      @Path("id")
      id: Int,
      @Body
      cliente: Cliente
   ): Cliente

   @PUT("flores/{id}")
   suspend fun actualizarFlores(
      @Path("id")
      id: Int,
      @Body
      flor: Flores
   ): Flores

   @PUT("empleados/{id}")
   suspend fun actualizarEmpleado(
      @Path("id")
      id: Int,
      @Body
      empleado: Empleado
   ): Empleado

   @PUT("tipo_flores/{id}")
   suspend fun actualizarTiposFlores(
      @Path("id")
      id: Int,
      @Body
      tipoFlores: TipoFlores
   ): TipoFlores
   @PUT("flores_marchitadas/{id}")
   suspend fun actualizarFloresMarchita(
      @Path("id")
      id: Int,
      @Body
      floresMarchitadas: FloresMarchitadas
   ): FloresMarchitadas
   /*----------------DELETES----------------*/
   @DELETE("clientes/{id}")
   suspend fun eliminarClientes(
      @Path("id")
      id: Int
   ): Cliente

   @DELETE("flores/{id}")
   suspend fun eliminarFlores(
      @Path("id")
      id: Int
   ): Flores

   @DELETE("empleados/{id}")
   suspend fun eliminarEmpleado(
      @Path("id")
      id: Int
   ): Empleado

   @DELETE("tipo_flores/{id}")
   suspend fun eliminarTiposFlores(
      @Path("id")
      id: Int
   ): TipoFlores

   @DELETE("flores_marchitadas/{id}")
   suspend fun eliminarFloresMarchitadas(
      @Path("id")
      id: Int
   ): FloresMarchitadas


}