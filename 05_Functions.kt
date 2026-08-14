fun ejercicio1() {
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5

    val urls = actions.map { action ->
        "$prefix/$id/$action"
    }

    println(urls)
}

fun repeatN(n: Int, action: () -> Unit) {
    repeat(n) {
        action()
    }
}

fun ejercicio2() {
    repeatN(5) {
        println("Hello")
    }
}

fun main() {
    println("Ejercicio 1:")
    ejercicio1()

    println("\nEjercicio 2:")
    ejercicio2()
}
