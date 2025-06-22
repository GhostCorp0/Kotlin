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