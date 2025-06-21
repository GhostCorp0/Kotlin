package com.ghostcorp.kotlin.Flows.course2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ghostcorp.kotlin.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FlowsChannelsActivity : AppCompatActivity() {
    val channel = Channel<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flows_channels)

        // Example of why here suspend is not a good idea to use
        // because suspend functions returns a single value and it will not return result until all data gets
        //filled up in the list but this will consume more time so i wanted that if i get the result then it
        // should be received immediately continuously so for that we have to use flows
        /*CoroutineScope(Dispatchers.Main).launch {
            getUserNames().forEach{
                Log.d("TAG", "Flows: $it ")
            }

        }*/

        producer()

        consumer()

    }


    /////// suspend functions disadvantage ///////

    private suspend fun getUserNames() : List<String> {
        val list = mutableListOf<String>()
        list.add(getUser(1))
        list.add(getUser(2))
        list.add(getUser(3))
        return list
    }

    private suspend fun getUser(id:Int) : String{
        delay(1000) // Assume network call
        return "User$id"
    }

    ////////////////////////////////////////////////////


    /////// Channels Example ///////

    fun producer() {
        CoroutineScope(Dispatchers.Main).launch{
            channel.send(1)
            channel.send(2)
        }
    }

    fun consumer() {
        CoroutineScope(Dispatchers.Main).launch{
            Log.d("TAG", "consumer: ${channel.receive().toString()} ")
            Log.d("TAG", "consumer: ${channel.receive().toString()} ")
        }
    }
    ///////

}