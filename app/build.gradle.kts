import org.jetbrains.kotlin.gradle.dsl.JvmTarget

// Plugins necesarios para compilar una aplicación Android con Jetpack Compose.
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    // Identificador interno del código fuente del módulo.
    namespace = "com.codelabs.state"
    compileSdk = 37

    defaultConfig {
        // Identificador de instalación de la aplicación.
        applicationId = "com.codelabs.state"

        // Versiones mínima y objetivo de Android definidas para la práctica.
        minSdk = 24
        targetSdk = 33

        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            // La práctica no requiere ofuscación ni reducción de código.
            isMinifyEnabled = false

            // Mantiene únicamente la configuración estándar de optimización.
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt")
            )
        }
    }

    // Java 17 es la versión usada para compilar el proyecto.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Kotlin genera bytecode compatible con Java 17.
    kotlin {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_17
        }
    }

    // Activa Jetpack Compose como sistema de interfaz de usuario.
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Funciones base de AndroidX y ciclo de vida de la Activity.
    implementation("androidx.core:core-ktx:1.19.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.11.0")

    // Integración de ViewModel con composables.
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.11.0")

    // Permite establecer contenido Compose desde una Activity.
    implementation("androidx.activity:activity-compose:1.13.0")

    // BOM para mantener compatibles las versiones de Compose.
    implementation(platform("androidx.compose:compose-bom:2026.09.00"))

    // Componentes principales de la interfaz.
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")

    // Ícono de cerrar utilizado en cada elemento de la lista.
    implementation("androidx.compose.material:material-icons-core")
}
