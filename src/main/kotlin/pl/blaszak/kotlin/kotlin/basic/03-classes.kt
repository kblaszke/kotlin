package pl.blaszak.kotlin.kotlin.basic

fun main() {
    val r = Rectangle(5.1, 2.2)
    println("primeter = ${r.perimeter}")
    println("area = ${r.area()}")
    println("max = ${maxOf(r.height, r.length)}")
}

open class Shape(private val height: Double, private val length: Double) {
    fun area() = height * length
}

class Rectangle(val height: Double, val length: Double): Shape(height, length) {
    var perimeter = (height + length) * 2
}