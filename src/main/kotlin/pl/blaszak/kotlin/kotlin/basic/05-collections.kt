package pl.blaszak.kotlin.kotlin.basic

fun main() {
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    printList(fruits)
    println()
    checkCollection(fruits)
    println()
    sortByLambda(fruits)
}

fun sortByLambda(fruits: List<String>) {
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

fun checkCollection(fruits: List<String>) {
    when {
        "orange" in fruits -> println("juicy")
        "apple" in fruits -> println("apple is fine too")
    }
}

fun printList(fruits: List<String>) {
    for (fruit in fruits) {
        println(fruit)
    }
}
