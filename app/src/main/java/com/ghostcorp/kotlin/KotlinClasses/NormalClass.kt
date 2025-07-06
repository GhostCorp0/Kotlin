package com.ghostcorp.kotlin.KotlinClasses

import java.io.File

class SessionStorage(private val file: File) {

    var counter = 0

    fun save(vale:String) {
        // ....
    }

    // inner class

    inner class FileHelper {
        fun createFileNotExist() {

        }
    }
}

fun main() {

    val sessionStorage1 = SessionStorage(File("hello.txt"))
    val sessionStorage2 = SessionStorage(File("world.txt"))

    println(sessionStorage1 == sessionStorage2) //prints false

    // they are compared based on the reference not the content.

}
