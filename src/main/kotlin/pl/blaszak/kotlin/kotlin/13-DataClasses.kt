package pl.blaszak.kotlin.kotlin

fun main() {
    val user1 = User("John")
    val user2 = User("John", 20)
    println("User 1: $user1")
    println("User 2: $user2")
    println("Are they equal? Ans = ${user1 == user2}")
    val user3 = user1.copy(age = 10)
    println("10 years old copy of $user1: $user3")
    val (name, age) = user3
    println("This is user with name = $name and age = $age")
}

data class User(val name: String = "", val age: Int = 0)