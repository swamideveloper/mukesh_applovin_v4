package com.fastcash.speedloancoach.quickloan.mukesh_pkg_ten;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class pro_eight {

    public static final String BASE_URL = "http://ip-api.com/";

    public static pro_seven getGeoApiService() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(pro_seven.class);
    }

}
