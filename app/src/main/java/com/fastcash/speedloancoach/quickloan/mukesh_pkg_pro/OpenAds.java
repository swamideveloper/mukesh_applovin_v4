package com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro;

import static androidx.lifecycle.Lifecycle.Event.ON_START;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.GOOGLE_AO;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager.appOpenContext;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.fastcash.speedloancoach.quickloan.R;

import org.jetbrains.annotations.Nullable;


public class OpenAds implements LifecycleObserver, Application.ActivityLifecycleCallbacks {
    private static final String LOG_TAG = "First_AppOpenManager";
    private static boolean isShowingAd = false;
    private final MyApp myApplication;
    public boolean isFrist = false;
    private AppOpenAd appOpenAd = null;
    private AppOpenAd.AppOpenAdLoadCallback loadCallback;
    private Activity currentActivity;

    public OpenAds(MyApp myApplication) {
        this.myApplication = myApplication;
        this.myApplication.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

    }

    public void showAdIfAvailable() {

        if (GOOGLE_AO.equals("No")) {
            if (appOpenContext != null && isFrist) {
                openAdDialig();
            } else {
                isFrist = true;
            }
        } else {
            if (!isShowingAd && isAdAvailable()) {
                Log.d(LOG_TAG, "Will show ad.");
                FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        OpenAds.this.appOpenAd = null;
                        isShowingAd = false;
                        fetchAd();
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        isShowingAd = true;
                    }
                };
                appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                appOpenAd.show(currentActivity);
            } else {
                Log.d(LOG_TAG, "Can not show ad.");
                fetchAd();
            }
        }
    }

    private void openAdDialig() {
        AlertDialog dialog = new AlertDialog.Builder(appOpenContext, R.style.DialogTheme).create();
        View view = LayoutInflater.from(appOpenContext).inflate(R.layout.pro_four, null, false);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        LinearLayout con = view.findViewById(R.id.btnContinue);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        LinearLayout cardView = view.findViewById(R.id.openQureka);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inter_Ads_Manager.getInstance().openChromeCustomTabUrl(appOpenContext);
            }
        });
        dialog.setView(view);
        dialog.show();
    }

    public void fetchAd() {

        if (isAdAvailable()) {
            return;
        }

        loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {

            @Override
            public void onAdLoaded(AppOpenAd ad) {
                OpenAds.this.appOpenAd = ad;
            }


            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
            }

        };
        AdRequest request = getAdRequest();
        AppOpenAd.load(myApplication, GOOGLE_AO, request, AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);
    }


    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }


    public boolean isAdAvailable() {
        return appOpenAd != null;
    }

    @Override
    public void onActivityCreated(Activity activity, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        currentActivity = activity;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        currentActivity = activity;

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        currentActivity = null;
    }

    @OnLifecycleEvent(ON_START)
    public void onStart() {
        showAdIfAvailable();
        Log.d(LOG_TAG, "onStart");
    }

}