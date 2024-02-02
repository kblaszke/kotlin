package pl.blaszak.kotlin.kotlin

fun main() {

    val box = Box(1) // 1 has type Int, so the compiler figures out that it is Box<Int>
    println("Value of box is ${box.value}")
    println()

}

class Box<T>(t: T) {
    var value = t
}

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 has type Double, which is a subtype of Number
    // Thus, you can assign x to a variable of type Comparable<Double>
    val y: Comparable<Double> = x // OK!
}