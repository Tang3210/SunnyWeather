package com.tang.sunnyweather.util

import android.widget.Toast
import com.tang.sunnyweather.MyApplication

fun String.toast(){
    toast(this)
}

fun toast(content : String, duration : Int = Toast.LENGTH_SHORT){
    Toast.makeText(MyApplication.context, content, duration).show()
}