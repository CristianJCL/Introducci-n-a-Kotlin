package com.codelabs.state

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Muestra las tareas dentro de una LazyColumn.
 *
 * LazyColumn crea y mantiene en composición principalmente los elementos
 * visibles, por lo que resulta adecuada para listas que pueden crecer.
 */
@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list,

            // La clave estable evita asociar el estado a la posición de la lista.
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,

                // Envía al nivel superior el nuevo estado del checkbox.
                onCheckedChange = { checked ->
                    onCheckedTask(task, checked)
                },

                // Informa qué tarea debe eliminarse.
                onClose = {
                    onCloseTask(task)
                }
            )
        }
    }
}
