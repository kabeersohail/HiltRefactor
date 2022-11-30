package com.example.hiltrefactor.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.hiltrefactor.InterfaceUsageWithHilt
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SampleService : Service() {

    @Inject lateinit var interfaceUsageWithHilt: InterfaceUsageWithHilt

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        interfaceUsageWithHilt.exampleMethodDefinition()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? = null
}