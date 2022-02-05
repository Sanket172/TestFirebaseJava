package com.example.testnotificationjava.builder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuilderGetToken {
    private static Retrofit instance;

    public BuilderGetToken() {
    }
    public static Retrofit getInstance(){
        if(instance==null){
            synchronized (BuilderGetToken.class){
                if(instance==null){
                    instance=new Retrofit.Builder().baseUrl("http://10.177.1.134:8079/").
                            addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();

//                    instance=new Retrofit.Builder().baseUrl("http://10.177.1.134:1001/").
//                            addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();


                }
            }
        }
        return instance;
    }
}
