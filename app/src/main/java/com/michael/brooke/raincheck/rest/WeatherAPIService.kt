package com.michael.brooke.raincheck.rest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {

    @GET("data/2.5/weather")
    fun getCurrentWeatherByCoordinates(@Query("lat") lat: Double, @Query("lon") long: Double): Call<WeatherPOJO>
}