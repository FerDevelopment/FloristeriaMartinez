package com.example.floristeriamartinez.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class Ruta<T : Any>(
   @StringRes val nombre: Int,
   val ruta: T,
   val iconoLleno: ImageVector,
   val iconoVacio: ImageVector
)