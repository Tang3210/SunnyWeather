package com.tang.sunnyweather

import android.app.Application
import android.content.Context

class MyApplication: Application() {

    companion object{
        const val TOKEN = "57VpOt72wSRQItAg" // 填入你申请到的令牌值

        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}