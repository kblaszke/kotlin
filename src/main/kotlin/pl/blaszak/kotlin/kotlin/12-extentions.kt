package pl.blaszak.kotlin.kotlin

import pl.blaszak.kotlin.kotlin.extensions.getLongestString
fun main() {
    MyClass.Companion.printCompanion()
    println()
    val list = listOf("red", "green", "blue")
    println(list.getLongestString())
    println()
    val host = Host("kotl.in")
    val connection = Connection(host, 443)
    connection.connect()
    println()
    println(connection.anotherConnectionString())
    println()
    BaseCaller().call(Base2())   // "Base extension function in BaseCaller"
    DerivedCaller().call(Base2())  // "Base extension function in DerivedCaller" - dispatch receiver is resolved virtually
    DerivedCaller().call(Derived2())  // "Base extension function in DerivedCaller" - extension receiver is resolved statically
}

open class Base2 { }

class Derived2 : Base2() { }

open class BaseCaller {
    open fun Base2.printFunctionInfo() {
        println("Base extension function in BaseCaller")
    }

    open fun Derived2.printFunctionInfo() {
        println("Derived extension function in BaseCaller")
    }

    fun call(b: Base2) {
        b.printFunctionInfo()   // call the extension function
    }
}

class DerivedCaller: BaseCaller() {
    override fun Base2.printFunctionInfo() {
        println("Base extension function in DerivedCaller")
    }

    override fun Derived2.printFunctionInfo() {
        println("Derived extension function in DerivedCaller")
    }
}

class MyClass {
    companion object { }  // will be called "Companion"
}

fun MyClass.Companion.printCompanion() { println("companion") }

class Host(val hostname: String) {
    fun printHostname() { print(hostname) }
    override fun toString(): String {
        return "Host(hostname='$hostname')"
    }

}

class Connection(val host: Host, val port: Int) {
    fun printPort() { print(port) }


    fun Host.printConnectionString() {
        printHostname()   // calls Host.printHostname()
        print(":")
        printPort()   // calls Connection.printPort()
    }
    fun Host.getConnectionString() {
        toString()         // calls Host.toString()
        this@Connection.toString()  // calls Connection.toString()
    }

    fun connect() {
        /*...*/
        host.printConnectionString()   // calls the extension function
    }

    fun Host.anotherWayOfConnectionString() {
        println(toString())         // calls Host.toString()
        println(this@Connection.toString())  // calls Connection.toString()
    }

    fun anotherConnectionString() {
        host.anotherWayOfConnectionString()
    }

    override fun toString(): String {
        return "Connection(host=$host, port=$port)"
    }
}
