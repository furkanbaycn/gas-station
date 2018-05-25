package com.example.furkanbaycan.gasstation.Remote;

import com.example.furkanbaycan.gasstation.Model.NearbySearch.gasPlaces;
import com.example.furkanbaycan.gasstation.Model.TextSearch.TextSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Furkan BAYCAN on 11.03.2018.
 */

public interface IGoogleAPIService {
    @GET
    Call<gasPlaces> getNearByPlaces(@Url String url);

    @GET
    Call<TextSearch> getTextSearch(@Url String url);


}
