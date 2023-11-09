package pl.blaszak.kotlin.kotlin


fun main() {

    println("Is 7 even? - ${isEven2.accept(7)}")

    println("Is 7 even? - ${isEven3(7)}")
}

typealias IntPredicate3 = (i: Int) -> Boolean

val isEven3: IntPredicate3 = { it % 2 == 0 }

val isEven = object : IntPredicate {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}

val isEven2 = IntPredicate { it % 2 == 0 }

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}