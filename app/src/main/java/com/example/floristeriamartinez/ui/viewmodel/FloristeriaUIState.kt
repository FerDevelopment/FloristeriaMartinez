package com.example.floristeriamartinez.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.floristeriamartinez.FloristeriaMartinez
import com.example.floristeriamartinez.datos.FloristeriaRepositorio
import com.example.floristeriamartinez.model.Cliente
import com.example.floristeriamartinez.model.Empleado
import com.example.floristeriamartinez.model.Flores
import com.example.floristeriamartinez.model.FloresMarchitadas
import com.example.floristeriamartinez.model.TipoFlores
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface FloristeriaUIState {
   /*-------------Flor-----------------*/
   data class ObtenerExitoFlores(val flores: List<Flores>) : FloristeriaUIState
   data class CrearExitoFlores(val flor: Flores) : FloristeriaUIState
   data class ActualizarExitoFlores(val flor: Flores) : FloristeriaUIState
   data class EliminarExitoFlores(val id: Int) : FloristeriaUIState

   /*-------------Clientes-----------------*/
   data class ObtenerExitoCliente(val clientes: List<Cliente>) : FloristeriaUIState
   data class CrearExitoCliente(val cliente: Cliente) : FloristeriaUIState
   data class ActualizarExitoCliente(val cliente: Cliente) : FloristeriaUIState
   data class EliminarExitoCliente(val id: Int) : FloristeriaUIState

   /*-------------Empleados-----------------*/
   data class ObtenerExitoEmpleado(val empleados: List<Empleado>) : FloristeriaUIState
   data class CrearExitoEmpleado(val empleado: Empleado) : FloristeriaUIState
   data class ActualizarExitoEmpleado(val empleado: Empleado) : FloristeriaUIState
   data class EliminarExitoEmpleado(val id: Int) : FloristeriaUIState

   /*-------------Tipo de flor-----------------*/
   data class ObtenerExitoTipoFlores(val tipoFlores: List<TipoFlores>) : FloristeriaUIState
   data class CrearExitoTipoFlores(val tipoFlor: TipoFlores) : FloristeriaUIState
   data class ActualizarExitoTipoFlores(val tipoFlor: TipoFlores) : FloristeriaUIState
   data class EliminarExitoTipoFlores(val id: Int) : FloristeriaUIState

   /*-------------Flores Marchitadas-----------------*/
   data class ObtenerExitoFloresMarchitadas(val floresMarchitadas: List<FloresMarchitadas>) :
      FloristeriaUIState

   data class CrearExitoFloresMarchitadas(val floresMarchitada: FloresMarchitadas) :
      FloristeriaUIState

   data class ActualizarExitoFloresMarchitadas(val floresMarchitada: FloresMarchitadas) :
      FloristeriaUIState

   data class EliminarExitoFloresMarchitadas(val id: Int) : FloristeriaUIState

   object Error : FloristeriaUIState
   object Cargando : FloristeriaUIState
}

class FloristeriaViewModel(private val floristeriaRepositorio: FloristeriaRepositorio) :
   ViewModel() {
   /*---------Variables---------*/
   var floristeriaUIState: FloristeriaUIState by mutableStateOf(FloristeriaUIState.Cargando)
      private set
   var florPulsada: Flores by mutableStateOf(Flores(0, "", 0, 0.0))
      private set
   var clientePulsado: Cliente by mutableStateOf(Cliente(0, "", "", ""))
      private set
   var empleadoPulsado: Empleado by mutableStateOf(Empleado(0, "", "", 0.0))
      private set
   var tipoFlorPulsado: TipoFlores by mutableStateOf(TipoFlores(0, ""))
      private set
   var florMarchitadaPulsada: FloresMarchitadas by mutableStateOf(FloresMarchitadas(0, 0, "", ""))

   /*------------------Funciones-----------------*//*Clientes*/
   fun obtenerClientes() {
      viewModelScope.launch {
         floristeriaUIState = FloristeriaUIState.Cargando
         floristeriaUIState = try {
            val listaClientes = floristeriaRepositorio.obtenerClientes()
            FloristeriaUIState.ObtenerExitoCliente(listaClientes)
         } catch (e: IOException) {
            FloristeriaUIState.Error
         } catch (e: HttpException) {
            FloristeriaUIState.Error
         }
      }
   }

   init {
      obtenerFlores()
   }

   /*Flores*/
   fun obtenerFlores() {
      viewModelScope.launch {
         floristeriaUIState = FloristeriaUIState.Cargando
         floristeriaUIState = try {
            val listaFlores = floristeriaRepositorio.obtenerFlores()
            FloristeriaUIState.ObtenerExitoFlores(listaFlores)
         } catch (e: IOException) {
            FloristeriaUIState.Error
         } catch (e: HttpException) {
            FloristeriaUIState.Error
         }
      }
   }

   fun actualizarFlorPulsada(flor: Flores) {
      florPulsada = flor
   }

   /*Empleados*/
   fun obtenerEmpleados() {
      viewModelScope.launch {
         floristeriaUIState = FloristeriaUIState.Cargando
         floristeriaUIState = try {
            val listaEmpleados = floristeriaRepositorio.obtenerEmpleados()
            FloristeriaUIState.ObtenerExitoEmpleado(listaEmpleados)
         } catch (e: IOException) {
            FloristeriaUIState.Error
         } catch (e: HttpException) {
            FloristeriaUIState.Error
         }
      }
   }

   /*Tipo de flores*/
   fun obtenerTipoFlores() {
      viewModelScope.launch {
         floristeriaUIState = FloristeriaUIState.Cargando
         floristeriaUIState = try {
            val listaTipoFlores = floristeriaRepositorio.obtenerTiposFlores()
            FloristeriaUIState.ObtenerExitoTipoFlores(listaTipoFlores)
         } catch (e: IOException) {
            FloristeriaUIState.Error
         } catch (e: HttpException) {
            FloristeriaUIState.Error
         }
      }
   }

   /*Flores Marchitadas*/
   fun obtenerFloresMarchitadas() {
      viewModelScope.launch {
         floristeriaUIState = FloristeriaUIState.Cargando
         floristeriaUIState = try {
            val listaFloresMarchitadas = floristeriaRepositorio.obtenerFloresMarchitadas()
            FloristeriaUIState.ObtenerExitoFloresMarchitadas(listaFloresMarchitadas)
         } catch (e: IOException) {
            FloristeriaUIState.Error
         } catch (e: HttpException) {
            FloristeriaUIState.Error
         }
      }
   }

   companion object {
      val Factory: ViewModelProvider.Factory = viewModelFactory {
         initializer {
            val aplicacion = (this[APPLICATION_KEY] as FloristeriaMartinez)
            val floristeriaRepositorio = aplicacion.contenedor.floristeriaRepositorio
            FloristeriaViewModel(floristeriaRepositorio = floristeriaRepositorio)
         }
      }

   }
}
