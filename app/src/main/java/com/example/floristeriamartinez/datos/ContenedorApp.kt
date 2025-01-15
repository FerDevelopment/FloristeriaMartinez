package com.example.floristeriamartinez.datos

import com.example.floristeriamartinez.conexion.FloristeriaApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface ContenedorApp {
   val floristeriaRepositorio: FloristeriaRepositorio
}

class FloristeriaCotenedorApp : ContenedorApp {
   private val baseUrl = "http://10.0.2.2:3000"
   private val json = Json { ignoreUnknownKeys = true }
   private val retrofit = Retrofit.Builder()
      .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
      .baseUrl(baseUrl)
      .build()
   private val servicioRetrofit: FloristeriaApi by lazy {
      retrofit.create(FloristeriaApi::class.java)
   }
   override val floristeriaRepositorio: FloristeriaRepositorio by lazy {
      ConexionFloristeriaRepositorio(servicioRetrofit)
   }
}