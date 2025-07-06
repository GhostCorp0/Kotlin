package com.ghostcorp.kotlin.KotlinClasses

data class Person(
    val name:String,
    val birtDate:String,
    val email:String
) {
    val age:Int
        get() {
            return 2023 - birtDate.substring(0,4).toInt()
        }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}