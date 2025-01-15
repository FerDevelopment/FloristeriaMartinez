package com.example.floristeriamartinez.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.floristeriamartinez.model.Flores
import com.example.floristeriamartinez.ui.components.CardFlores

@Composable
fun MostrarListaFlores(flores: List<Flores>, modifier: Modifier= Modifier) {
   LazyColumn( modifier = modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceBetween
   ) {
      items(flores) { flor ->
         CardFlores(flor)
      }
   }
}

