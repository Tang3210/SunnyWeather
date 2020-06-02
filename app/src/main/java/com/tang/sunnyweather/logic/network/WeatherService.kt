package com.tang.sunnyweather.logic.network

import com.tang.sunnyweather.MyApplication
import com.tang.sunnyweather.logic.model.DailyResponse
import com.tang.sunnyweather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("v2.5/${MyApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String):
            Call<RealtimeResponse>

    @GET("v2.5/${MyApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String):
            Call<DailyResponse>
}