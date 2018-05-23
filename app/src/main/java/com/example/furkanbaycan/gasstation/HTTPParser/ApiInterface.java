package com.example.furkanbaycan.gasstation.HTTPParser;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {
    @GET()
    Call<String> getStringResponse(@Url String url);
}
