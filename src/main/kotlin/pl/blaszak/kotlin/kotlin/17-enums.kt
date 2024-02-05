package pl.blaszak.kotlin.kotlin

fun main() {

}

enum class PROTOCOL_STATE {

    WAITING{
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): PROTOCOL_STATE
}