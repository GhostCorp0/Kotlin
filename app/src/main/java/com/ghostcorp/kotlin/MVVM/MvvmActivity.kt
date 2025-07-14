package com.ghostcorp.kotlin.MVVM

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ghostcorp.kotlin.R
import com.ghostcorp.kotlin.databinding.ActivityMvvmBinding

class MvvmActivity : AppCompatActivity() {
    lateinit var binding: ActivityMvvmBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm)
        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()

        val repository = QuoteRepository(dao)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.getQuotes().observe(this) {
            binding.quotes = it.toString()
        }

        binding.btnAddQuote.setOnClickListener {
            val quote = Quote(0,"This is testing","Testing")
            mainViewModel.insertQuote(quote)
        }

    }
}