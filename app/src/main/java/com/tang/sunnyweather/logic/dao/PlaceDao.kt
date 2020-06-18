package com.tang.sunnyweather.logic.dao

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.tang.sunnyweather.MyApplication
import com.tang.sunnyweather.logic.model.Place

object PlaceDao {

    private fun sharedPreferences() =
        MyApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)

    fun savePlace(place: Place){
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getPlace(): Place {
        val place = sharedPreferences().getString("place", "")
        return Gson().fromJson(place, Place::class.java)
    }

    fun isPlaceSave() = sharedPreferences().contains("place")
}