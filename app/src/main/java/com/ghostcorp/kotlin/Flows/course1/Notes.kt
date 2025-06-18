package com.ghostcorp.kotlin.Flows.course1

class Notes {

    /**
     *   What are Flows ?
     *
     *  In Kotlin Flows are a part of kotlin coroutines library and are used for asynchronous data streams. They let you emit multiples values over time, unlike a
     *  suspend function which returns only a single value.
     *
     *  Real world analogy:
     *
     *  Think of a flow like a stream of water coming out of a tap -it can produce multiple droplets(values) one after another, and you can collect these droplets
     *  to use them.
     *
     *  Why use Flow:
     *
     *  - Handle asynchronous streams of data.
     *
     *  - Replace things like RxJava or LiveData in many use-cases
     *
     *  - Automatically support backpressure (doesn't overload the collect)
     *
     *  - Integrate with coroutines easily.
     *
     *
     * There are three main types of flows, each with different characteristic and use cases:
     *
     * 1 - Cold Flows (default Flow)
     *
     * What:
     *
     * - Flow starts running only when collected.
     *
     * - Every collector gets a fresh execution of flow block.
     *
     * Use case : Fetching data on demand (e.g - database query,network call)
     *
     *  Example:
     *
     *  fun getNumbers(): Flow<Int> = flow {
     *     println("Flow started")
     *     emit(1)
     *     emit(2)
     * }
     *
     * runBlocking {
     *     getNumbers().collect { println("First: $it") }
     *     getNumbers().collect { println("Second: $it") }
     * }
     *
     *
     * 2 - Hot Flows (Shared Flow types)
     *
     * Hot flows are always active - they don't depend on collectors to emit data.
     *
     * Two main types:
     *
     * SharedFlow
     *
     * - Broadcasts values to multiple collectors.
     * - Does not retain the latest value by default (but can buffer)
     *
     * Example:
     *
     * val sharedFlow = MutableSharedFlow<Int>()
     *
     * // Emit
     * launch { sharedFlow.emit(1) }
     *
     * // Collect
     * launch {
     *     sharedFlow.collect { println("Collector1: $it") }
     * }
     *
     * StateFlow
     * - A state-holder  always holds the latest value
     *
     * - Like LiveData, but built for coroutines.
     *
     * Example:
     *
     * val stateFlow = MutableStateFlow(0)
     *
     * // Emit new value
     * stateFlow.value = 10
     *
     * // Collect latest value
     * launch {
     *     stateFlow.collect { println("Current state: $it") }
     * }
     *
     * Channel -
     *
     * While not a Flow, Channel is another tool for 1 - to - 1 or broadcast communication, but it's not recommended for most new coroutine-based apps
     *
     * Flow, SharedFlow and StateFlow are the preferred modern tools.
     *
     *
     *  -- In Mutable Shared Flow we have
     *
     *  replay - Use replay when you want to give last values to the new collector
     *
     *  extraBufferCapacity  - To increase the buffer capacity
     *
     *  onBufferOverflow - If buffer exceeds the limit of current buffers then what to do decides.
     *
     *  It has three types :
     *
     *  BufferOverflow.SUSPEND - it suspends the collection till the buffer clears so that it can
     *
     *  accept new values and when it gets cleared then resume and keep that data in new buffer while suspension.
     *
     *  By using this there is no data loss.
     *
     *
     *  BufferOverflow.DROP_LATEST - it drops the latest values if buffer is filled and new values
     *  are getting.
     *
     *  BufferOverflow.DROP_OLDEST -  it drops the oldest values if buffer is filled and new values
     *  are getting.
     *
     *
     *
     * /// State Flows ////
     *
     * State flows gives us the last value emitted on configuration changes so that app does not lose the
     * state.
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