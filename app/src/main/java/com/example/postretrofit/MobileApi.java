package com.example.postretrofit;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MobileApi {

    @FormUrlEncoded
    @POST("mobiles")
    Call<JsonObject> getMobileApiInfo(@Field("userid") String userid);


}
