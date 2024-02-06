package pl.blaszak.kotlin.kotlin

fun main() {
    val b = BaseImpl(10)
    val derived = Derived3(b)
    derived.print()
    derived.printMessage()
    derived.printMessageLine()
    derived.printStringMessage()
    println(derived.message)
}

interface Base3 {
    val message: String
    fun print()
    fun printMessage()
    fun printMessageLine()
    fun printStringMessage()
}

class BaseImpl(private val x: Int) : Base3 {

    override val message = "BaseImpl: x = $x"

    override fun print() { println(x) }
    override fun printMessage() { println(x) }
    override fun printMessageLine() { println(x) }
    override fun printStringMessage() {
        println(message)
    }
}

class Derived3(b: Base3) : Base3 by b {

    override val message = "Message of Derived"
    override fun printMessageLine() {
        println("abc")
    }
}