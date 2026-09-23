package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Composable con estado.
 *
 * rememberSaveable conserva el número de vasos incluso si la Activity
 * se recrea, por ejemplo durante un cambio de configuración.
 */
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }

    // El estado se eleva hacia este composable y se entrega al hijo.
    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )
}

/**
 * Composable sin estado.
 *
 * Recibe el valor actual y la acción que debe ejecutarse al pulsar el botón.
 * De esta manera puede reutilizarse y probarse sin almacenar estado propio.
 */
@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        // El texto solo se muestra después de registrar al menos un vaso.
        if (count > 0) {
            Text("You've had $count glasses.")
        }

        Button(
            onClick = onIncrement,
            // La práctica limita el contador a un máximo de diez vasos.
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}
