package com.example.furkanbaycan.gasstation.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Furkan BAYCAN on 11.03.2018.
 */

public class RetrofitClient {
    private static Retrofit retrofit = null;
    public static  Retrofit getClient(String baseUrl){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
