package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Pantalla principal de la práctica.
 *
 * Combina el contador de agua con la lista de tareas y obtiene
 * WellnessViewModel para conservar el estado de la pantalla.
 */
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        // Contador independiente que conserva su propio estado guardable.
        StatefulCounter()

        // La lista recibe datos y eventos; el ViewModel modifica el estado real.
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
}
