package com.example.hiltrefactor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hiltrefactor.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /**
     * Note:
     * 1. Field injections cannot be private
     * 2. Class with no Inject constructor cannot be injected
     */
    @Inject lateinit var exampleClassThatCanBeInjected: ExampleClassThatCanBeInjected

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.test.setOnClickListener {
            exampleClassThatCanBeInjected.exampleMethod()
        }

    }
}