package com.thedesignerx.saim.new_message_app;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterfaceRegister {
    
        @POST("register.php")
        Call<RegistrationsResponse> getRegister(@Body RegistrationsRequest registerationRequest);

}
