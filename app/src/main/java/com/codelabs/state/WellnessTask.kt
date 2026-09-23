package com.codelabs.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Representa una tarea individual de bienestar.
 *
 * Cada tarea tiene un identificador único, una etiqueta y un estado
 * de selección observable por Jetpack Compose.
 */
class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {
    /**
     * Estado de selección de la tarea.
     *
     * mutableStateOf permite que Compose detecte cambios y recomponga
     * únicamente las partes de la interfaz que dependen de este valor.
     */
    var checked: Boolean by mutableStateOf(initialChecked)
}
