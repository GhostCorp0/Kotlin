package com.ghostcorp.kotlin.KotlinClasses

enum class HttpStatus(val code:Int) {
    OK(200),
    BAD_REQUEST(400),
    NOT_FOUND(404);

    fun toResponseString() : String {
        return "Error $code"
    }
}

fun main() {
    val response = HttpStatus.NOT_FOUND

    println(response.toResponseString())

    HttpStatus.entries.forEach{
        println(it.code)
    }
}