package com.ghostcorp.kotlin.KotlinClasses

sealed class NetworkResult {
    data class Success(val data:String) : NetworkResult()
    data class Error(val throwable:Throwable) : NetworkResult()
    data object Empty : NetworkResult()
}