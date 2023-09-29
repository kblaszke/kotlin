package pl.blaszak.kotlin.kotlin.basic

fun main() {
    val a: Int = 1  // immediate assignment
    val b = 2   // `Int` type is inferred

    var x = 5 // `Int` type is inferred
    x += 1

    fun incrementX() {
        x += 1
    }

    var c = a + b
    println(c)
    println(x)
    incrementX()
    println(x)

}