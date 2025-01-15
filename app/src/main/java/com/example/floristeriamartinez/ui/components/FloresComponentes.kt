package com.example.floristeriamartinez.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.floristeriamartinez.model.Flores

@Composable
fun CardFlores(flor: Flores) {
   Card(modifier = Modifier
      .fillMaxWidth()
      .padding(4.dp)) {
      Column {
         Row {
            Text(text = flor.id.toString())
            Text(text = flor.nombre)
         }
         Row {
            Text(text = flor.precio.toString())
            Text(text = flor.tipoFlores.toString())
         }
      }
   }
}
