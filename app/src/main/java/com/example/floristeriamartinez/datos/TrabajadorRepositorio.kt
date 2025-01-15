package com.example.floristeriamartinez.datos

import com.example.floristeriamartinez.conexion.FloristeriaApi
import com.example.floristeriamartinez.model.Cliente
import com.example.floristeriamartinez.model.Empleado
import com.example.floristeriamartinez.model.Flores
import com.example.floristeriamartinez.model.FloresMarchitadas
import com.example.floristeriamartinez.model.TipoFlores

interface FloristeriaRepositorio {
   // Métodos para Flores
   suspend fun obtenerFlores(): List<Flores>
   suspend fun insertarFlor(flor: Flores): Flores
   suspend fun actualizarFlor(id: String, flor: Flores): Flores
   suspend fun eliminarFlor(id: String): Flores

   // Métodos para Tipos de Flores
   suspend fun obtenerTiposFlores(): List<TipoFlores>
   suspend fun insertarTipoFlor(tipoFlor: TipoFlores): TipoFlores
   suspend fun actualizarTipoFlor(id: String, tipoFlor: TipoFlores): TipoFlores
   suspend fun eliminarTipoFlor(id: String): TipoFlores

   // Métodos para Flores Marchitadas
   suspend fun obtenerFloresMarchitadas(): List<FloresMarchitadas>
   suspend fun insertarFlorMarchitada(florMarchitada: FloresMarchitadas): FloresMarchitadas
   suspend fun actualizarFlorMarchitada(id: String, florMarchitada: FloresMarchitadas
   ): FloresMarchitadas

   suspend fun eliminarFlorMarchitada(id: String): FloresMarchitadas

   // Métodos para Clientes
   suspend fun obtenerClientes(): List<Cliente>
   suspend fun insertarCliente(cliente: Cliente): Cliente
   suspend fun actualizarCliente(id: String, cliente: Cliente): Cliente
   suspend fun eliminarCliente(id: String): Cliente

   // Métodos para Trabajadores (Empleados)
   suspend fun obtenerTrabajadores(): List<Empleado>
   suspend fun insertarTrabajador(trabajador: Empleado): Empleado
   suspend fun actualizarTrabajador(id: String, trabajador: Empleado): Empleado
   suspend fun eliminarTrabajador(id: String): Empleado
}

class ConexionFloristeriaRepositorio(private val floristeriaApi: FloristeriaApi
) : FloristeriaRepositorio {
   override suspend fun obtenerTrabajadores(): List<Empleado> = floristeriaApi.obtenerEmpleados()

   override suspend fun insertarTrabajador(trabajador: Empleado): Empleado =
           floristeriaApi.insertarEmpleado(trabajador)

   override suspend fun actualizarTrabajador(id: Int, trabajador: Empleado): Empleado =
           floristeriaApi.actualizarEmpleado(id, trabajador)

   override suspend fun eliminarTrabajador(id: Int): Empleado = floristeriaApi.eliminarEmpleado(id)

   /* Métodos para Flores */
   override suspend fun obtenerFlores(): List<Flores>
   override suspend fun insertarFlor(flor: Flores): Flores
   override suspend fun actualizarFlor(id: String, flor: Flores): Flores
   override suspend fun eliminarFlor(id: String): Flores

   /* Métodos para Tipos de Flores */
   override suspend fun obtenerTiposFlores(): List<TipoFlores>
   override suspend fun insertarTipoFlor(tipoFlor: TipoFlores): TipoFlores
   override suspend fun actualizarTipoFlor(id: String, tipoFlor: TipoFlores): TipoFlores
   override suspend fun eliminarTipoFlor(id: String): TipoFlores

   /* Métodos para Flores Marchitadas */
   override suspend fun obtenerFloresMarchitadas(): List<FloresMarchitadas>
   override suspend fun insertarFlorMarchitada(florMarchitada: FloresMarchitadas): FloresMarchitadas
   override suspend fun actualizarFlorMarchitada(id: String, florMarchitada: FloresMarchitadas
   ): FloresMarchitadas

   override suspend fun eliminarFlorMarchitada(id: String): FloresMarchitadas

   /* Métodos para Clientes */
   override suspend fun obtenerClientes(): List<Cliente>
   override suspend fun insertarCliente(cliente: Cliente): Cliente
   override suspend fun actualizarCliente(id: String, cliente: Cliente): Cliente
   override suspend fun eliminarCliente(id: String): Cliente
}