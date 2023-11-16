package pl.blaszak.kotlin.kotlin

fun main() {

    val list = mutableListOf(1, 2, 3)
    println("list before swapping $list")
    list.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'list'
    println("list after swapping $list")
    println()
    printClassName(Rectangle5())
    println()
    Example().printFunctionType()
    println()
    Example2().printFunctionType(1)
    println()
    println("nullable object toString() method: ${null.toString()}")
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

open class Shape2
class Rectangle5: Shape2()
fun Shape2.getName() = "Shape"
fun Rectangle5.getName() = "Rectangle"
fun printClassName(s: Shape2) {
    println(s.getName())
}

class Example {
    fun printFunctionType() { println("Class method") }
}
fun Example.printFunctionType() { println("Extension function") }

class Example2 {
    fun printFunctionType() { println("Class method") }
}
fun Example2.printFunctionType(i: Int) { println("Extension function #$i") }

fun Any?.toString(): String {
    if (this == null) return "null"
    // After the null check, 'this' is autocast to a non-nullable type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}