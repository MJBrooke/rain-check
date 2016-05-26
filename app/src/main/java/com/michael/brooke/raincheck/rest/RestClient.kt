package com.michael.brooke.raincheck.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    val restClient = buildClient()

    private val baseUrl = "http://api.openweathermap.org"

    private fun buildClient(): Retrofit =
        Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getCustomInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    private fun getCustomInterceptor() =
        OkHttpClient
            .Builder()
            .addInterceptor({ chain ->
                val request = chain!!.request()
                val originalUrl = request.url()

                //TODO - create an extension for this
                val newUrl = originalUrl
                        .newBuilder()
                        .addQueryParameter("appid", "15646a06818f61f7b8d7823ca833e1ce")
                        .build()

                val newRequest = request.newBuilder().url(newUrl).build()

                chain.proceed(newRequest)
            })
            .build()

//    class CustomInterceptor(): Interceptor {
//
//        override fun intercept(chain: Interceptor.Chain?): Response? {
//            val request = chain!!.request()
//            val originalUrl = request.url()
//
//            val newUrl = originalUrl.newBuilder().addQueryParameter("appid", "15646a06818f61f7b8d7823ca833e1ce").build()
//
//            val newRequest = request.newBuilder().url(newUrl).build()
//
//            return chain.proceed(newRequest)
//        }
//
//    }
}