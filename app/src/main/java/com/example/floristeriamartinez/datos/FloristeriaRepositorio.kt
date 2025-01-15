package com.example.floristeriamartinez.datos

import com.example.floristeriamartinez.conexion.FloristeriaApi
import com.example.floristeriamartinez.model.Cliente
import com.example.floristeriamartinez.model.Empleado
import com.example.floristeriamartinez.model.Flores
import com.example.floristeriamartinez.model.FloresMarchitadas
import com.example.floristeriamartinez.model.TipoFlores

/*Esta interfaz va a tener LITERALMENTE los mismos metodos que la Api*/
interface FloristeriaRepositorio {
   // Métodos para Flores
   suspend fun obtenerFlores(): List<Flores>
   suspend fun insertarFlor(flor: Flores): Flores
   suspend fun actualizarFlor(id: Int, flor: Flores): Flores
   suspend fun eliminarFlor(id: Int): Flores

   // Métodos para Tipos de Flores
   suspend fun obtenerTiposFlores(): List<TipoFlores>
   suspend fun insertarTipoFlor(tipoFlor: TipoFlores): TipoFlores
   suspend fun actualizarTipoFlor(id: Int, tipoFlor: TipoFlores): TipoFlores
   suspend fun eliminarTipoFlor(id: Int): TipoFlores

   // Métodos para Flores Marchitadas
   suspend fun obtenerFloresMarchitadas(): List<FloresMarchitadas>
   suspend fun insertarFlorMarchitada(florMarchitada: FloresMarchitadas): FloresMarchitadas
   suspend fun actualizarFlorMarchitada(id: Int, florMarchitada: FloresMarchitadas
   ): FloresMarchitadas

   suspend fun eliminarFlorMarchitada(id: Int): FloresMarchitadas

   // Métodos para Clientes
   suspend fun obtenerClientes(): List<Cliente>
   suspend fun insertarCliente(cliente: Cliente): Cliente
   suspend fun actualizarCliente(id: Int, cliente: Cliente): Cliente
   suspend fun eliminarCliente(id: Int): Cliente

   // Métodos para Trabajadores (Empleados)
   suspend fun obtenerEmpleados(): List<Empleado>
   suspend fun insertarEmpleado(trabajador: Empleado): Empleado
   suspend fun actualizarEmpleado(id: Int, trabajador: Empleado): Empleado
   suspend fun eliminarEmpleado(id: Int): Empleado
}
/*Esta clase se utiliza para implementar dichos metodos.
MUY PERO MUY Recomendable poner los nombres de los metodos igual que estan en la api y la
interfaz. Esta clase se usa a modo de capa entre el viewmodel y la api*/

class ConexionFloristeriaRepositorio(private val floristeriaApi: FloristeriaApi
) : FloristeriaRepositorio {
   override suspend fun obtenerEmpleados(): List<Empleado> = floristeriaApi.obtenerEmpleados()

   override suspend fun insertarEmpleado(trabajador: Empleado): Empleado =
           floristeriaApi.insertarEmpleado(trabajador)

   override suspend fun actualizarEmpleado(id: Int, trabajador: Empleado): Empleado =
           floristeriaApi.actualizarEmpleado(id, trabajador)

   override suspend fun eliminarEmpleado(id: Int): Empleado = floristeriaApi.eliminarEmpleado(id)

   /* Métodos para Flores */
   override suspend fun obtenerFlores(): List<Flores> = floristeriaApi.obtenerFlores()
   override suspend fun insertarFlor(flor: Flores): Flores = floristeriaApi.insertarFlores(flor)
   override suspend fun actualizarFlor(id: Int, flor: Flores): Flores =
           floristeriaApi.actualizarFlores(id, flor)

   override suspend fun eliminarFlor(id: Int): Flores = floristeriaApi.eliminarFlores(id)

   /* Métodos para Tipos de Flores */
   override suspend fun obtenerTiposFlores(): List<TipoFlores> = floristeriaApi.obtenerTiposFlores()
   override suspend fun insertarTipoFlor(tipoFlor: TipoFlores): TipoFlores =
           floristeriaApi.insertarTiposFlores(tipoFlor)

   override suspend fun actualizarTipoFlor(id: Int, tipoFlor: TipoFlores): TipoFlores =
           floristeriaApi.actualizarTiposFlores(id, tipoFlor)

   override suspend fun eliminarTipoFlor(id: Int): TipoFlores =
           floristeriaApi.eliminarTiposFlores(id)

   /* Métodos para Flores Marchitadas */
   override suspend fun obtenerFloresMarchitadas(): List<FloresMarchitadas> =
           floristeriaApi.obtenerFloresMarchitadas()

   override suspend fun insertarFlorMarchitada(florMarchitada: FloresMarchitadas): FloresMarchitadas =
           floristeriaApi.insertarFloresMarchitadas(florMarchitada)

   override suspend fun actualizarFlorMarchitada(id: Int, florMarchitada: FloresMarchitadas
   ): FloresMarchitadas = floristeriaApi.actualizarFloresMarchita(id, florMarchitada)

   override suspend fun eliminarFlorMarchitada(id: Int): FloresMarchitadas =
           floristeriaApi.eliminarFloresMarchitadas(id)

   /* Métodos para Clientes */
   override suspend fun obtenerClientes(): List<Cliente> = floristeriaApi.obtenerClientes()
   override suspend fun insertarCliente(cliente: Cliente): Cliente =
           floristeriaApi.insertarClientes(cliente)

   override suspend fun actualizarCliente(id: Int, cliente: Cliente): Cliente =
           floristeriaApi.actualizarClientes(id, cliente)

   override suspend fun eliminarCliente(id: Int): Cliente = floristeriaApi.eliminarClientes(id)
}