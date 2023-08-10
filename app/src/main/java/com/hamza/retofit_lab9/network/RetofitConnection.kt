package com.hamza.retofit_lab9.network

import com.hamza.retofit_lab9.utils.Const
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetofitConnection {


//     private fun provideRetrofit(): Retrofit =
//        Retrofit.Builder().baseUrl(Const.BASE_URL)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//    fun provideApiServices(): ApiCalls =
//        provideRetrofit().create(ApiCalls::class.java)

    fun getRetrofit(): ApiCalls {
        var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        var okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder().baseUrl(Const.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiCalls::class.java)
    }

}