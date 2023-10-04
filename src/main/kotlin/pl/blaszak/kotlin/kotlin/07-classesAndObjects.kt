package pl.blaszak.kotlin.kotlin

fun main() {
    val od = InitOrderDemo("Blaszak")
    println()
    val od2 = InitOrderDemo2()
    println("String ${od2.name} has ${od2.nameLength} long name variable")
    val c = Customer("Blaszak")

    val blaszak = Person()
    Pet("Marysia", blaszak)
    println("Person blaszak looks like: ${blaszak}")

    println()

    Constructors(7)

    println()

    Circle().draw()

    println()

    Derived("hello", "world")

    println()

    FilledSquare().draw()

    println()

    FilledSquare2().draw()

    println()

    Square3().draw()

}

open class Rectangle3 {
    open fun draw() { println("open class Rectangle3 draw") }
}

interface Polygon3 {
    fun draw() { println("interface Polygon3 draw") } // interface members are 'open' by default
}

class Square3(): Rectangle3(), Polygon3 {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        println("Square3 draw")
        super<Rectangle3>.draw() // call to Rectangle.draw()
        super<Polygon3>.draw() // call to Polygon.draw()
    }
}

class FilledSquare2: Square() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() { println("Filling") }
        fun drawAndFill() {
            super@FilledSquare2.draw() // Calls Rectangle's implementation of draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledSquare2.borderColor}") // Uses Rectangle's implementation of borderColor's get()
        }
    }
}

open class Square {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledSquare : Square() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}

open class Base(val name: String) {

    init { println("Initializing a base class") }

    open val size: Int =
        name.length.also { println("Initializing size in the base class: $it") }
}

class Derived(
    name: String,
    val lastName: String,
) : Base(name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }) {

    init { println("Initializing a derived class") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
}

class Circle(override val vertexCount: Int = 4) : Shape() {

    final override fun draw() {
        super.draw()
        println("I'm a Circle Shape. VertexCount=${vertexCount}")
    }
}
open class Shape {

    open val vertexCount: Int = 0
    open fun draw() {
        println("I'm a Shape. VertexCount=${vertexCount}")
    }
}

abstract class WildShape : Shape() {
    // Classes that inherit WildShape need to provide their own
    // draw method instead of using the default on Polygon
    abstract override fun draw()
}

abstract class Polygon {
    abstract fun draw()
}

class Rectangle : Polygon() {
    override fun draw() {
        println("Rectangle override fun draw")
    }

}

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor $i")
    }
}

class Person(val pets: MutableList<Pet> = mutableListOf()) {
    override fun toString(): String {
        return "Person(pets=$pets)"
    }
}

class Pet(val name: String) {

    constructor(name: String, owner: Person) : this(name) {
        owner.pets.add(this) // adds this pet to the list of its owner's pets
    }

    override fun toString(): String {
        return "Pet(name='$name')"
    }
}

class Customer public constructor(name: String)

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class InitOrderDemo2(
    val name: String = "Blaszak is king!",
    val nameLength: Int = name.length,
    ) {

}