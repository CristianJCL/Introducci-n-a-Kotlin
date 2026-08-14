import kotlin.random.Random

data class Employee(
    val name: String,
    var salary: Int
)

data class Name(
    val firstName: String,
    val lastName: String
)

data class City(
    val name: String,
    val country: String
)

data class Address(
    val street: String,
    val city: City
)

data class Person(
    val name: Name,
    val address: Address,
    val ownsAPet: Boolean = true
)

class RandomEmployeeGenerator(
    var minSalary: Int,
    var maxSalary: Int
) {
    private val names = listOf(
        "John",
        "Mary",
        "Ann",
        "Paul",
        "Elizabeth"
    )

    fun generateEmployee(): Employee {
        val randomName = names.random()
        val randomSalary = Random.nextInt(minSalary, maxSalary + 1)

        return Employee(randomName, randomSalary)
    }
}

fun ejercicio1() {
    val emp = Employee("Mary", 20)
    println(emp)

    emp.salary += 10

    println(emp)
}

fun ejercicio2() {
    val person = Person(
        Name("John", "Smith"),
        Address(
            "123 Fake Street",
            City("Springfield", "US")
        ),
        ownsAPet = false
    )

    println(person)
}

fun ejercicio3() {
    val empGen = RandomEmployeeGenerator(10, 30)

    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())

    empGen.minSalary = 50
    empGen.maxSalary = 100

    println(empGen.generateEmployee())
}

fun main() {
    println("Ejercicio 1:")
    ejercicio1()

    println("\nEjercicio 2:")
    ejercicio2()

    println("\nEjercicio 3:")
    ejercicio3()
}
