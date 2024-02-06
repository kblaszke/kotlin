package pl.blaszak.kotlin.kotlin

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main() {
    val e = Example3()
    println(e.p)
    e.p = "NEW"

    println(lazyValue)
    println(lazyValue)

    val user = User2()
    user.name = "first"
    user.name = "second"

    val user3 = User3(mapOf(
        "name" to "John Doe",
        "age"  to 25
    ))
    println(user3.name) // Prints "John Doe"
    println(user3.age)

}

class Example3 {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

class User2 {
    var name: String by Delegates.observable("<no name>") {
            prop, old, new ->
        println("$old -> $new")
    }
}

var topLevelInt: Int = 0
class ClassWithDelegate(val anotherClassInt: Int)

class MyClass3(var memberInt: Int, val anotherClassInstance: ClassWithDelegate) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}
var MyClass3.extDelegated: Int by ::topLevelInt

class User3(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

