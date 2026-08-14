fun ejercicio1() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)

    val totalCount = greenNumbers.count() + redNumbers.count()

    println("Total de numeros: $totalCount")
}

fun ejercicio2() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"

    val isSupported = requested.uppercase() in SUPPORTED

    println("Support for $requested: $isSupported")
}

fun ejercicio3() {
    val number2word = mapOf(
        1 to "one",
        2 to "two",
        3 to "three"
    )

    val n = 2

    println("$n is spelled as '${number2word[n]}'")
}

fun main() {
    println("Ejercicio 1:")
    ejercicio1()

    println("\nEjercicio 2:")
    ejercicio2()

    println("\nEjercicio 3:")
    ejercicio3()
}
