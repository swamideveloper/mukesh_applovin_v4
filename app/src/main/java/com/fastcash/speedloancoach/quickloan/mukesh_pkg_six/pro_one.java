package com.fastcash.speedloancoach.quickloan.mukesh_pkg_six;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class pro_one {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("settings")
    @Expose
    private pro_two SFLoanSt;
    @SerializedName("response")
    @Expose
    private List<pro_three> SFLoanAppVariables = new ArrayList<>();

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<pro_three> getAppVariables() {
        return SFLoanAppVariables;
    }

    public void setAppVariables(List<pro_three> SFLoanAppVariables) {
        this.SFLoanAppVariables = SFLoanAppVariables;
    }

    public pro_two getSettings() {
        return SFLoanSt;
    }

    public void setSettings(pro_two SFLoanSt) {
        this.SFLoanSt = SFLoanSt;
    }
}