package com.codelabs.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.codelabs.state.ui.theme.BasicStateCodelabTheme

/**
 * Activity principal de la aplicación.
 *
 * Su única responsabilidad es crear el contenido Compose y aplicar
 * el tema general antes de mostrar la pantalla de bienestar.
 */
class MainActivity : ComponentActivity() {

    /**
     * Punto de entrada de la Activity.
     * setContent sustituye la interfaz XML tradicional por composables.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Aplica colores y tipografía definidos para toda la aplicación.
            BasicStateCodelabTheme {
                // Surface ocupa la pantalla y usa el color de fondo del tema.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Pantalla que contiene el contador y la lista de tareas.
                    WellnessScreen()
                }
            }
        }
    }
}
