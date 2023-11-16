package pl.blaszak.kotlin.kotlin

fun main() {
    log(IOError.FileReadError)
    log(IOError.DatabaseError)
}

fun log(e: IOError): Unit = when(e) {
    is IOError.DatabaseError -> println("Database Error")
    is IOError.FileReadError -> println("File Read Error")
}

sealed interface Error

sealed class IOError: Error {
    data object FileReadError : IOError()
    data object DatabaseError : IOError()
}