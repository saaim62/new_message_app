package com.thedesignerx.saim.new_message_app;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("9a8fbf1e")
    Call<LoginResponse> getlogin(@Body LoginRequest loginRequest);
//    String BASE_URL = "http://192.168.1.7:9090/loginapp/";
//    @GET("login.php")
//    Call<LoginResponse> getlogin();
}
