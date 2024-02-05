package pl.blaszak.kotlin.kotlin

fun main() {
    println(Outer.Nested().foo())
    println(Outer2().getInnerInstance().foo())
}

class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

class Outer2 {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
    fun getInnerInstance() = Inner()
}