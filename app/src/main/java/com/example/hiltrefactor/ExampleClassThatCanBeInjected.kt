package com.example.hiltrefactor

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class ExampleClassThatCanBeInjected @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun exampleMethod() {
        Toast.makeText(context, "I am injected successfully", Toast.LENGTH_SHORT).show()
    }
}