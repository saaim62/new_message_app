package com.thedesignerx.saim.new_message_app

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val retrofit: Retrofit
        private get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            return Retrofit.Builder()
                    .baseUrl("https://api.mocki.io/v1/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

    @JvmStatic
    val apiInterface: ApiInterface
        get() = retrofit.create(ApiInterface::class.java)

//    @JvmStatic
//    val apiInterfaceRegister: ApiInterfaceRegister
//        get() = retrofit.create(ApiInterfaceRegister::class.java)
}