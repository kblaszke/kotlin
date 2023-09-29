package pl.blaszak.kotlin.kotlin.basic

fun main() {
    printProduct("2", "3")
    printProduct("3", "kk")
    // val s = parseInt("kk") ?: throw IllegalArgumentException("Int value expected")
    val s = parseInt("kk") ?: fail("Int value expected")

}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun parseInt(str: String): Int? {
    try {
        return str.toInt()
    } catch (ex: Exception) {
        return null
    }

}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    }
    else {
        println("'$arg1' or '$arg2' is not a number")
    }
}