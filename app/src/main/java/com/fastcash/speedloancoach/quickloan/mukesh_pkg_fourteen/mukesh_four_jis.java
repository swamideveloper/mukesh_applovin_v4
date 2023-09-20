package com.fastcash.speedloancoach.quickloan.mukesh_pkg_fourteen;

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_six.pro_one;

import retrofit2.Call;
import retrofit2.http.GET;

public interface mukesh_four_jis {
    @GET("getApps/mukesh/SF_Loan/D4SSSSBYMIU69/v4/getData.json")
    Call<pro_one> getSdkData();

}