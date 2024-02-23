package pl.blaszak.kotlin.kotlin

fun main() {
    read("Blaszak is king".encodeToByteArray())
    read("Blaszak is king".encodeToByteArray(), off = 200)

    foo(1) { println("1. hello") }
    foo(baz = { println("2. hello") })
    foo { println("3. hello") }

    println("Double of 17 = ${double(17)}")
    println(3 shl 4)
    println(3.shl(4))

    println(stringFunction("Blaszak is king of animals"))

    println(findFixPoint())
}

fun read(b: ByteArray, off: Int = 0, len: Int = b.size) {
    println("default arguments function. off = $off, len = $len")
}

fun foo(
    bar: Int = 0,
    baz: () -> Unit,
) {
    baz.invoke()
}

fun double(x: Int): Int = x * 2

infix fun Int.shl(x: Int): Int { return x * 2 + x % 3 }

fun stringFunction(s: String): String {
    fun reverseString(ss: String): String {
        return ss.uppercase().reversed()
    }
    return "${s.uppercase()} in reversion = ${reverseString(s)}"
}

val eps = 1E-10 // "good enough", could be 10^-15

tailrec fun findFixPoint(x: Double = 1.0): Double =
    if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))