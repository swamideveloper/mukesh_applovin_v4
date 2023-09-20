package com.fastcash.speedloancoach.quickloan.mukesh_pkg_ten;

import retrofit2.Call;
import retrofit2.http.GET;

public interface pro_seven {
    @GET("json")
    Call<pro_six> getLocation();
}