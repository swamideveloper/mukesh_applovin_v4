package com.fastcash.speedloancoach.quickloan.mukesh_pkg_twelve;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class mukesh_four_kaa implements Serializable {
    @SerializedName("resultCode")
    @Expose
    private Integer resultCode;
    @SerializedName("resultData")
    @Expose
    private List<mukesh_four_paiyaa> resultData = null;
    @SerializedName("totalMoney")
    @Expose
    private Integer totalMoney;

    public static mukesh_four_kaa parseJSON(String str) {
        return (mukesh_four_kaa) new GsonBuilder().create().fromJson(str, mukesh_four_kaa.class);
    }

    public List<mukesh_four_paiyaa> getResultData() {
        return this.resultData;
    }

    public void setResultData(List<mukesh_four_paiyaa> list) {
        this.resultData = list;
    }

    public Integer getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(Integer num) {
        this.resultCode = num;
    }

    public Integer getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(Integer num) {
        this.totalMoney = num;
    }
}
