package com.ghostcorp.kotlin.KotlinScope

import android.content.Intent


// let example
fun main() {
    var number: Int? = null
    var i = 0

    val x = number?.let {
        val number2 = it +1
        number2
    } ?: 3

    // also example
    fun getSquaredI() = (i * i).also { i++ }

    //apply example
    val intent = Intent().apply {
        putExtra("name","neon")
        putExtra("age",23)
    }

    // run example
    val intent2 = Intent().run {
        putExtra("name","neon")
        putExtra("age",23)
    }

    //with example
    with(Intent()) {

    }
}

