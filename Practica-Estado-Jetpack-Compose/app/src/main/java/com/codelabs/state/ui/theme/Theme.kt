package com.codelabs.state.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Paleta usada cuando el sistema está en modo oscuro.
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

// Paleta usada cuando el sistema está en modo claro.
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

/**
 * Aplica el tema visual de la práctica.
 *
 * En Android 12 o superior intenta utilizar los colores dinámicos del
 * dispositivo; en versiones anteriores utiliza las paletas locales.
 */
@Composable
fun BasicStateCodelabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // Selecciona la paleta apropiada según versión y configuración del sistema.
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current

    // Evita modificar la ventana cuando el composable solo se muestra en preview.
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window

            // Sincroniza la barra de estado con el color principal del tema.
            window.statusBarColor = colorScheme.primary.toArgb()

            // Ajusta el contraste de los iconos de la barra de estado.
            WindowCompat
                .getInsetsController(window, view)
                .isAppearanceLightStatusBars = !darkTheme
        }
    }

    // Proporciona colores y tipografía al árbol completo de composables.
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
