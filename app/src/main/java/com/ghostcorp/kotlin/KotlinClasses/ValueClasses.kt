package com.ghostcorp.kotlin.KotlinClasses

@JvmInline
@Deprecated
value class Email @Deprecated constructor(val email:String) {

    init {
        if(!email.contains("@")) {
            throw IllegalArgumentException("Invalid Email")
        }
    }

}