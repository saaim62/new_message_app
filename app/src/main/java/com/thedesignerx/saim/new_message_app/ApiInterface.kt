package com.thedesignerx.saim.new_message_app

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("9a8fbf1e")
    fun getlogin(@Body loginRequest: LoginRequest?): Call<LoginResponse?>?

}