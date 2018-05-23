package com.example.furkanbaycan.gasstation;

import com.example.furkanbaycan.gasstation.Remote.IGoogleAPIService;
import com.example.furkanbaycan.gasstation.Remote.RetrofitClient;

/**
 * Created by Furkan BAYCAN on 12.03.2018.
 */

public class Common {
    private static final String GOOGLE_API_URL = "https://maps.googleapis.com/";
    public static IGoogleAPIService getGoogleAPIService(){
        return RetrofitClient.getClient(GOOGLE_API_URL).create(IGoogleAPIService.class);
    }
}
