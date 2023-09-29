package pl.blaszak.kotlin.kotlin.basic

fun main() {
    val items = listOf("apple", "banana", "kiwifruit")
    forLoop(items)
    println()
    forLoop2(items)
    println()
    myWhileLoop(items)
    println()
    println(whenExpression(5.25))
    println()
    fitsInRange(10, 9)
    println()
    backwardFor(9)
}

fun backwardFor(y: Int) {
    for (x in y downTo 0 step 3) {
        print(x)
    }
}

fun fitsInRange(x: Int, y: Int) {
    if (x in 1..y) {
        println("fits in range")
    } else {
        println("doesn't fit")
    }
}

fun whenExpression(o: Any): String =
    when (o) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }

fun myWhileLoop(items: List<String>) {
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

fun forLoop2(items: List<String>) {
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun forLoop(items: List<String>) {
    for (item in items) {
        println(item)
    }
}
