package com.example.floristeriamartinez.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.floristeriamartinez.R
import com.example.floristeriamartinez.model.Ruta
import com.example.floristeriamartinez.ui.screens.MostrarListaFlores
import com.example.floristeriamartinez.ui.viewmodel.FloristeriaUIState
import com.example.floristeriamartinez.ui.viewmodel.FloristeriaViewModel

enum class Pantallas(@StringRes val titulo: Int) {
   PantallaClientes(titulo = R.string.clientes),
   PantallaEmpleado(titulo = R.string.empleados),
   PantallaFlores(titulo = R.string.flores),
   PantallaFloresMarchitadas(titulo = R.string.floresMarchitadas),
   PantallaTipoFlores(titulo = R.string.tipoFlores),

}

val listaRutas = listOf(
   Ruta(
      Pantallas.PantallaFlores.titulo,
      Pantallas.PantallaFlores.name,
      Icons.Filled.ShoppingCart,
      Icons.Outlined.ShoppingCart
   ),
   Ruta(
      Pantallas.PantallaClientes.titulo,
      Pantallas.PantallaClientes.name,
      Icons.Filled.AccountCircle,
      Icons.Outlined.AccountCircle
   ),
   Ruta(
      Pantallas.PantallaEmpleado.titulo,
      Pantallas.PantallaEmpleado.name,
      Icons.Filled.Face,
      Icons.Outlined.Face
   ),
   Ruta(
      Pantallas.PantallaFloresMarchitadas.titulo,
      Pantallas.PantallaFloresMarchitadas.name,
      Icons.Filled.Share,
      Icons.Outlined.Share
   ),
   Ruta(
      Pantallas.PantallaTipoFlores.titulo,
      Pantallas.PantallaTipoFlores.name,
      Icons.Filled.Menu,
      Icons.Outlined.Menu
   )
)

@Composable
fun FloristeriaMartinezApp(
   viewModel: FloristeriaViewModel = viewModel(factory = FloristeriaViewModel.Factory),
   navController: NavHostController = rememberNavController(),
) {
   var selectedItem by remember { mutableIntStateOf(0) }

   Scaffold(
      bottomBar = {
         NavigationBar {
            listaRutas.forEachIndexed { indice, ruta ->
               NavigationBarItem(
                  icon = {
                     if (selectedItem == indice)
                        Icon(
                           imageVector = ruta.iconoLleno,
                           contentDescription = stringResource(id = ruta.nombre)
                        )
                     else
                        Icon(
                           imageVector = ruta.iconoVacio,
                           contentDescription = stringResource(id = ruta.nombre)
                        )
                  },
                  label = { Text(stringResource(id = ruta.nombre)) },
                  selected = selectedItem == indice,
                  onClick = {
                     selectedItem = indice
                     navController.navigate(ruta.ruta)
                  }
               )
            }
         }
      },
      modifier = Modifier.fillMaxSize()
   ) { innerPadding ->
      val uiState = viewModel.floristeriaUIState
      NavHost(
         navController = navController,
         startDestination = Pantallas.PantallaFlores.name,
         modifier = Modifier.padding(innerPadding)
      ) {
         // Grafo de las rutas
         composable(route = Pantallas.PantallaEmpleado.name) {
         }
         composable(route = Pantallas.PantallaTipoFlores.name) {
         }
         composable(route = Pantallas.PantallaFloresMarchitadas.name) {
         }
         composable(route = Pantallas.PantallaFlores.name) {
            /*Pantalla inicial*/

            when (uiState) {
               is FloristeriaUIState.ObtenerExitoFlores -> {
                  MostrarListaFlores(uiState.flores)
               }

               else -> {
                  viewModel.obtenerFlores()
               }
            }
         }
         composable(route = Pantallas.PantallaClientes.name) {
         }
      }
   }
}