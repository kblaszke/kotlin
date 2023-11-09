package pl.blaszak.kotlin.kotlin

fun main() {

    var rect1 = Rectangle1(3, 4)
    println("Rectangle ${rect1.width} x ${rect1.height} area = ${rect1.area}")
    // rect1.area = 15

    println()

    val rect2 = Rectangle2(2, 3)
    println("Rectangle area = ${rect2.area}")
}

class Rectangle1(var width: Int, var height: Int) {
    var area = this.width * this.height
        private set
}
class Rectangle2(val width: Int, val height: Int) {
    val area get() = this.width * this.height
}

class Rectangle4()