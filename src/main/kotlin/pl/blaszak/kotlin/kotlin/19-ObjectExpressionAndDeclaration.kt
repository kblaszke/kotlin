package pl.blaszak.kotlin.kotlin

import java.lang.reflect.Constructor

fun main() {
    println(helloWorld)
    val window = Window()
    window.addMouseListener(object: MouseAdapter {
        override fun mouseClicked(e: MouseEvent) {
            println("Mouse clicked")
        }
        override fun mouseEntered(e: MouseEvent) {
            println("Mouse entered")
        }
    })

    DataProviderManager.registerDataProvider(object: DataProvider {
        override fun toString() = "Anonymous Data Provider"
    })
    DataProviderManager.shawDataProviders()

    val evilTwin = createInstanceViaReflection()

    println(MySingleton) // MySingleton
    println(evilTwin) // MySingleton

    // Even when a library forcefully creates a second instance of MySingleton, its `equals` method returns true:
    println(MySingleton == evilTwin) // true

    // Do not compare data objects via ===.
    println(MySingleton === evilTwin) // false

    println(Number2(7)) // Number(number=7)
    println(EndOfFile) // EndOfFile

    val myClass2 = MyClass2.create()
}

val helloWorld = object {
    val hello = "Hello"
    val world = "World"
    // object expressions extend Any, so `override` is required on `toString()`
    override fun toString() = "$hello $world"
}

class Window {
    fun addMouseListener(mouse: MouseAdapter) {
        println("Window::addMouseListener")
    }
}

interface MouseAdapter {
    fun mouseClicked(e: MouseEvent)
    fun mouseEntered(e: MouseEvent)
}
interface MouseEvent

interface A2 {
    fun funFromA() {}
}

class C2 {
    // The return type is Any; x is not accessible
    fun getObject() = object {
        val x: String = "x"
    }

    // The return type is A; x is not accessible
    fun getObjectA() = object : A2 {
        override fun funFromA() {}
        val x: String = "x"
    }
}

interface DataProvider
object DataProviderManager {
    private val allDataProviders = mutableListOf<DataProvider>()

    fun registerDataProvider(provider: DataProvider) {
        allDataProviders.add(provider)
    }

    fun shawDataProviders() {
        allDataProviders.forEach{ println(it)}
    }
}

data object MySingleton

fun createInstanceViaReflection(): MySingleton {
    // Kotlin reflection does not permit the instantiation of data objects.
    // This creates a new MySingleton instance "by force" (i.e. Java platform reflection)
    // Don't do this yourself!
    return (MySingleton.javaClass.declaredConstructors[0].apply { isAccessible = true } as Constructor<MySingleton>).newInstance()
}

sealed interface ReadResult
data class Number2(val number: Int) : ReadResult
data class Text(val text: String) : ReadResult
data object EndOfFile : ReadResult

class MyClass2 {
    companion object Factory {
        fun create(): MyClass2 = MyClass2()
    }
}