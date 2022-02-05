package com.example.testnotificationjava.RetrofitInterface;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GetTokenInterface {

    @POST("/get/token/{tokenId}")
    Call<Void> postLogPlace(@Path("tokenId") String tokenId);
}
