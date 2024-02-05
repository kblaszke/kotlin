package pl.blaszak.kotlin.kotlin


fun main() {
    val securePassword = Password("Don't try this in production")
}

@JvmInline
value class Password(private val textForm: String)