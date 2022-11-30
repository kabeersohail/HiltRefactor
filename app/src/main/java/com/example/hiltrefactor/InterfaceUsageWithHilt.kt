package com.example.hiltrefactor

import android.content.Context
import android.widget.Toast
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

interface InterfaceUsageWithHilt {
    fun exampleMethodDefinition()
}

class InterfaceUsageWithHiltImpl @Inject constructor(
    @ApplicationContext private val context: Context
): InterfaceUsageWithHilt {
    override fun exampleMethodDefinition() {
        Toast.makeText(context, "Interface usage with Hilt", Toast.LENGTH_SHORT).show()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfaceUsageWithHiltModule {
    @Binds
    abstract fun bindInterfaceUsageWithHilt(interfaceUsageWithHiltImpl: InterfaceUsageWithHiltImpl): InterfaceUsageWithHilt
}