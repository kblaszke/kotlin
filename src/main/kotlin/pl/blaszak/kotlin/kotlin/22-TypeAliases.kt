package pl.blaszak.kotlin.kotlin

import java.io.File

typealias FileTable<K> = MutableMap<K, MutableList<File>>

class A3 {
    inner class Inner
}
class B3 {
    inner class Inner
}

typealias AInner = A3.Inner
typealias BInner = B3.Inner