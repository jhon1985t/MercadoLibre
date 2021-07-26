package com.jhonjto

import android.app.Application

/**
 * Created by jhon on 23/07/2021
 */
class ConfigurationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}
