package com.ghostcorp.kotlin.Flows.course1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class FlowsViewModel : ViewModel(){
    // Shared Flow


    // use replay when you want to provide last values to the new collector
    val sharedFlow = MutableSharedFlow<Int>(
        replay = 4,
        extraBufferCapacity = 4,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    // To convert a shared flow in state flow

    /*val sharedFlow = MutableSharedFlow<Int>(
        replay = 4,
        extraBufferCapacity = 4,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    ).stateIn(viewModelScope, started = SharingStarted.WhileSubscribed(), initialValue = 0)*/


    init {
       // sharedFlowTesting()
       // stateFlowTesting()
        channelFlowTesting()
    }

    fun sharedFlowTesting() {
        viewModelScope.launch {
            repeat(10){
                delay(1000)
                sharedFlow.emit(it)
            }
        }
    }

    // State Flow
     val stateFlow = MutableStateFlow(0)

    //To convert a stateFlow in shared flow

   /* val stateFlow = MutableStateFlow(0).shareIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        replay = 1
    )*/

    /*val _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.shareIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        replay = 1
    )*/

    fun stateFlowTesting() {
        viewModelScope.launch {
            repeat(10){
                delay(1000)
                stateFlow.emit(it)
            }
        }
    }


    // Channel Flows

    val channel = Channel<Int>(
        capacity = 2,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
        onUndeliveredElement = {
            Log.d("TAG", "onUndeliveredElement: ${it}")
        }
    )

    val mChannel = channel.consumeAsFlow()  // create as cold Flow

 //   val mChannel = channel.receiveAsFlow() // Create as hot Flow

    fun channelFlowTesting() {
        viewModelScope.launch {
            repeat(10) {
                channel.send(it)
            }
        }
    }


    // Callback flows

    fun firebaseAuth() = callbackFlow<String>{
        FirebaseAuth.getInstance().signInWithEmailAndPassword("","")
            .addOnSuccessListener {
                trySend("success")
            }
            .addOnFailureListener{
                trySend("failure")
            }
            .addOnCanceledListener {
                trySend("cancel")
            }

        awaitClose {

        }
    }

    ////////
    //Flow builders

    val flow = flow<String> {
        emit("abcd")  // cold flow
    }

    val flowOf = flowOf("","dkdkd","ffj")

}