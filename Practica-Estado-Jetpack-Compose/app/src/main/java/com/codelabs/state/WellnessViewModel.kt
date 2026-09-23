package com.codelabs.state

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

/**
 * Administra el estado de la lista de tareas fuera de los composables.
 *
 * Al utilizar un ViewModel, la información puede sobrevivir a recreaciones
 * de la Activity mientras la pantalla siga perteneciendo al mismo alcance.
 */
class WellnessViewModel : ViewModel() {

    // Lista mutable observable, accesible únicamente dentro del ViewModel.
    private val _tasks = getWellnessTasks().toMutableStateList()

    /**
     * Expone una vista de solo lectura para evitar modificaciones directas
     * desde la interfaz.
     */
    val tasks: List<WellnessTask>
        get() = _tasks

    /**
     * Elimina una tarea. Al cambiar la lista observable, Compose actualiza
     * automáticamente la LazyColumn.
     */
    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    /**
     * Actualiza el checkbox de una tarea identificándola por su id.
     */
    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
    }
}

/**
 * Genera las treinta tareas iniciales utilizadas por la práctica.
 */
private fun getWellnessTasks(): List<WellnessTask> =
    List(30) { i ->
        WellnessTask(
            id = i,
            label = "Task # $i"
        )
    }
