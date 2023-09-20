package com.fastcash.speedloancoach.quickloan.mukesh_pkg_six;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class pro_four {

    @SerializedName("apps_name")
    @Expose
    private String appsName;
    @SerializedName("apps_logo")
    @Expose
    private String appsLogo;
    @SerializedName("apps_link")
    @Expose
    private String appsLink;

    public String getAppsName() {
        return appsName;
    }

    public void setAppsName(String appsName) {
        this.appsName = appsName;
    }

    public String getAppsLogo() {
        return appsLogo;
    }

    public void setAppsLogo(String appsLogo) {
        this.appsLogo = appsLogo;
    }

    public String getAppsLink() {
        return appsLink;
    }

    public void setAppsLink(String appsLink) {
        this.appsLink = appsLink;
    }

}