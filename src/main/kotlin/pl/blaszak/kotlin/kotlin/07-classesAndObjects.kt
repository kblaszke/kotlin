package pl.blaszak.kotlin.kotlin

import sun.security.util.Length

fun main() {
    val od = InitOrderDemo("Blaszak")
    println()
    val od2 = InitOrderDemo2()
    println("String ${od2.name} has ${od2.nameLength} long name variable")
    val c = Customer("Blaszak")

}

class Customer public constructor(name: String)

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class InitOrderDemo2(
    val name: String = "Blaszak is king!",
    val nameLength: Int = name.length,
    ) {

}