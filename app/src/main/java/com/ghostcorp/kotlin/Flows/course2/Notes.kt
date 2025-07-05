package com.ghostcorp.kotlin.Flows.course2

class Notes {
    /**
     *   Coroutine helps to implement asynchronous, non blocking code.
     *
     *   For this we use - suspend functions
     *
     *   Either you fire and forget using launch or wait for data (single object) using async.
     *
     *   suspend functions only return a single object.
     *
     *   suspend functions work great for things like:
     *
     *   - Storing some value in database.
     *
     *   - Network Calls
     *
     *   -Doings tasks that return a single value.
     *
     *
     *   -- But there are scenarios where you have streams of data.
     *
     *   -- Video Streaming.
     *
     *   -- FM Radio
     *
     *   -- Mobile sending audio signals to bluetooth speakers
     *
     *   -- Stocks data
     *
     *   -- For these scenarios, we need a stream.
     *
     *   suspend functions only return a single value, but flow helps to collect stream data.
     *
     *   -- Kotlin has asynchronous stream support using Channels & Flows.
     *
     *   -- Channel(Send & Receive)
     *
     *   -- Flows(emit & collect)
     *
     *
     *  ---- CHANNELS & FLOWS -------
     *
     *  -- Kotlin has asynchronous stream support using channels & flows
     *
     *  -- Channels (Send & Receive)
     *
     *  --Flows (Emit & Collect)
     *
     *  -- Channels are hot
     *
     *  -- Flows are mostly cold.
     *
     *
     *  ----- Flows (Streams)--------
     *
     *  Observer ----- Observable
     *
     *  Cold streams are preferred over hot streams.
     *
     *  -- Resource wastage
     *
     *  -- Manual Close
     *
     *
     *  -- producer consumer bottlenecks
     *
     *  -- bottlenecks
     *
     *  -- asynchronous
     *
     *  -- Cold
     *
     *
     * --- Kotlin Flow Operators -- Terminal - Map, Filter buffer operators ---
     *
     *  There are two types of operators terminal and non terminal
     *
     *  -- To start a flow we need terminal operators.
     *
     *  -- Flow consumption is done with the help of terminal operators like collect is terminal operator and terminal operators has suspend functions.
     *
     *
     *  --  first() will return the first element of flow and similarly there is one toList() which will convert the flow in to a form of list.
     *
     *
     *  --- Non terminal operators --
     *
     *  -- for example map() to convert one object into another object.
     *
     *  -- producer().map {it * 2}.filter{it < 8}.collect {}
     *
     *
     *  -- Kotlin flow context preservation (flowOn) + Exception Handling (catch)
     *
     *
     *  -- Kotlin Shared Flows
     *
     *  -- Mostly flows are of cold nature and this means flows will not produce if they dont have any consumer.
     *
     *  -- Every consumer has its own independent flow object.
     *
     *  -- replay plays last values which are defined
     *
     *
     *  -- STATE FLOWS ---
     *
     *  It holds the latest value and passes to every consumer it maintains the state of the flow.
     *
     *  It is of hot nature.
     *
     *
     * private fun producer() : Flow<Int> {
     *
     *   val mutableStateFlow = MutableStateFlow(0)
     *
     *   GlobalScope.launch {
     *         delay(2000)
     *         mutablestateflow.emit(20)
     *   }
     *
     *   return mutableStateFlow
     * }
     *
     *   val result = producer()
     *
     *   delay(1000)
     *
     *   result.collect {
     *       //
     *   }
     *
     *   it will store the last value and when someone will collect can get the last value.
     *
     *   also consumer can get the last value anytime using (.value) property
     *
     *
     *  ///// LiveData vs StateFlow ////////
     *
     *  -- Transformation on Main Thread
     *
     *  --  Operators
     *
     *  -- Lifecycle Dependent
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
}