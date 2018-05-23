package com.example.furkanbaycan.gasstation.HTTPParser;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context context, String baseUrl) {
        if (retrofit==null) {

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

}
