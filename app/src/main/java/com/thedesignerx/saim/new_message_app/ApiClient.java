package com.thedesignerx.saim.new_message_app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    @NotNull
    private static Retrofit getRetrofit() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mocki.io/v1/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
    public static ApiInterface getApiInterface (){
        ApiInterface apiInterface = getRetrofit().create(ApiInterface.class);
        return apiInterface;
    }

    public static ApiInterfaceRegister getApiInterfaceRegister() {
        ApiInterfaceRegister apiInterfaceRegister = getRetrofit().create(ApiInterfaceRegister.class);
        return apiInterfaceRegister;
    }
}