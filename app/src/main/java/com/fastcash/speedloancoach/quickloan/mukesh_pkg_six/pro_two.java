package com.fastcash.speedloancoach.quickloan.mukesh_pkg_six;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class pro_two {

    @SerializedName("loc_type")
    @Expose
    private String locType;
    @SerializedName("loc_array")
    @Expose
    private List<pro_five> SFLoanArr;

    public String getLocType() {
        return locType;
    }

    public void setLocType(String locType) {
        this.locType = locType;
    }

    public List<pro_five> getLocArray() {
        return SFLoanArr;
    }

    public void setLocArray(List<pro_five> SFLoanArr) {
        this.SFLoanArr = SFLoanArr;
    }

}