import kotlin.random.Random

fun ejercicio1() {
    val firstResult = Random.nextInt(6)
    val secondResult = Random.nextInt(6)

    println("Primer dado: $firstResult")
    println("Segundo dado: $secondResult")

    if (firstResult == secondResult) {
        println("You win :)")
    } else {
        println("You lose :(")
    }
}

fun ejercicio2() {
    val button = "A"

    println(
        when (button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else -> "There is no such button"
        }
    )
}

fun main() {
    println("Ejercicio 1:")
    ejercicio1()

    println("\nEjercicio 2:")
    ejercicio2()
}
