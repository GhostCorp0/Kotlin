package com.ghostcorp.kotlin.Flows.course2

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun getShippingDetails(userList:List<User>) : Flow<ShippingDetail> {
    return flow {
        userList.forEach{
            val user = getUser(use)
        }
    }

}



fun main () {
    val userList = getUserList()
    val shippingDetails = getShippingDetails()
}