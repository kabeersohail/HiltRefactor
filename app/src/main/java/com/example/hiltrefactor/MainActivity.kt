package com.example.hiltrefactor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.hiltrefactor.databinding.ActivityMainBinding
import com.example.hiltrefactor.services.SampleService
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

    @Inject lateinit var interfaceUsageWithHilt: InterfaceUsageWithHilt

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.classTest.setOnClickListener {
            exampleClassThatCanBeInjected.exampleMethod()
        }

        binding.interfaceTest.setOnClickListener {
            interfaceUsageWithHilt.exampleMethodDefinition()
        }

        binding.serviceTest.setOnClickListener {
            Intent(this, SampleService::class.java).also { serviceIntent ->
                startService(serviceIntent)
            }
        }

    }
}