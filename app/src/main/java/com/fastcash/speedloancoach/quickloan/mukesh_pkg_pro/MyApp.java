package com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import androidx.appcompat.app.AppCompatDelegate;

import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MyApp extends android.app.Application {
    private static final String TAG = "Application_RvcS_";
    public static MyApp MYApplication = null;

    public MyApp() {
        MYApplication = this;
    }

    public static synchronized MyApp getInstance() {
        MyApp MYApplication2;
        synchronized (MyApp.class) {
            MYApplication2 = MYApplication;
        }
        return MYApplication2;
    }

    public static MyApp getApp() {
        if (MYApplication == null) {
            MYApplication = new MyApp();
        }
        return MYApplication;
    }

    @SuppressLint("WrongConstant")
    public void onCreate() {
        super.onCreate();

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        MobileAds.initialize(
                this,
                new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                    }
                });

        AppLovinSdk.getInstance(this).setMediationProvider("max");
        AppLovinSdk.initializeSdk(this, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration) {

            }
        });


        MYApplication = this;

        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());


    }
}
