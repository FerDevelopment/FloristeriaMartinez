package com.example.floristeriamartinez

import android.app.Application
import com.example.floristeriamartinez.datos.ContenedorApp
import com.example.floristeriamartinez.datos.FloristeriaCotenedorApp

class FloristeriaMartinez :Application() {
   lateinit var contenedor: ContenedorApp
   override fun onCreate() {
      super.onCreate()
      contenedor = FloristeriaCotenedorApp()
   }
}