package com.ghostcorp.kotlin.KotlinClasses

abstract class Sensor {

    abstract val name:String

    abstract fun  startListening(onNewValue:(Float) -> Unit)
}

open class HeartRateSensor() : Sensor() {
    override val name: String
        get() = "Heart Rate Sensor"

    override fun startListening(onNewValue: (Float) -> Unit) {

    }

}

class CustomHeartRateSensor() : HeartRateSensor() {

}


fun main() {
    val specialSensor = object : Sensor() {
        override val name: String
            get() = "Special  Sensor"

        override fun startListening(onNewValue: (Float) -> Unit) {

        }

    }
}