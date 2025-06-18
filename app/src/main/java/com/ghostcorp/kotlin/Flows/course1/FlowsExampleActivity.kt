package com.ghostcorp.kotlin.Flows.course1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ghostcorp.kotlin.R

class FlowsExampleActivity : AppCompatActivity() {
    private val viewModel : FlowsViewModel by viewModels()
    private val TAG:String = "FlowsExampleActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flows_example)

        //For shared flow

       /* lifecycleScope.launch {
            viewModel.sharedFlow.collectLatest {
                Log.d(TAG,"onCreate_One : ${it}")
            }
        }

        lifecycleScope.launch {
            delay(4000)
            viewModel.sharedFlow.collectLatest {
                Log.d(TAG,"onCreate_Two : ${it}")
            }
        }*/

        // For state flow
/*
        lifecycleScope.launch {
            viewModel.stateFlow.collectLatest {
                Log.d(TAG,"onCreate_Two : ${it}")
            }
        }
*/

        // For channel
       /* lifecycleScope.launch {
            viewModel.mChannel.collectLatest {
                Log.d(TAG,"onCreate : ${it}")
            }
        }*/

        //For callback flow
       /* lifecycleScope.launch {
            viewModel.firebaseAuth().collectLatest {
                Log.d(TAG,"onCreate : ${it}")
            }
        }*/


    }
}