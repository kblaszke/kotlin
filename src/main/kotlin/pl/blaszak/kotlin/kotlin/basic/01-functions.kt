package pl.blaszak.kotlin.kotlin.basic

fun main() {
    println(" 1 + 2 = ${sum0(1, 2)}")
    println(" 2 + 3 = ${sum1(2, 3)}")
    printSum0(3, 4)
    println("max of 5.1 and 2.2 is ${maxOf(5.1, 2.2)}")
}

fun sum0(a: Int, b: Int): Int {
    return a + b
}

fun sum1(a: Int, b: Int) = a + b

fun maxOf(a: Double, b: Double) = if (a > b) a else b

fun printSum0(a: Int, b: Int) {
    println(" $a + $b = ${a + b} ")
}
