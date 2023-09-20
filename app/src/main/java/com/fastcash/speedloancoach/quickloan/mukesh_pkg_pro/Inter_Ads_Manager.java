package com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro;


import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.APPLOVIN_B;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.APPLOVIN_I;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.APPLOVIN_N;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.AdsType;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.GOOGLE_B;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.GOOGLE_I;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.GOOGLE_N;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.adCounterBanner;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.adCounterInterstitial;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.adCounterNative;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.adSwitch;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.counter;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.extraswitch;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.native_counter;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.other3;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.qurekaLink;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.splashSwitch;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.browser.customtabs.CustomTabsIntent;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.fastcash.speedloancoach.quickloan.R;

import java.util.Arrays;


public class Inter_Ads_Manager {
    public static int adIndex = 1;
    public static int nativetvadIndex = 1;
    public static Context appOpenContext;
    private static Inter_Ads_Manager mInstance;
    private static ProgressDialog progressDialog;
    public InterstitialAd interstitial;
    MyCallback myCallback;
    AdRequest adRequest;
    private AdView adView;

    public static Inter_Ads_Manager getInstance() {
        if (mInstance == null) {
            mInstance = new Inter_Ads_Manager();
        }
        return mInstance;
    }

    public static boolean isNetworkAvailable(Activity activity) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void moreApp(Context context) {
        final String appPackageName = context.getPackageName();
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }

    }

    public void hideView(View view) {
        if (extraswitch.equals("0")) {
            view.setVisibility(View.INVISIBLE);
        }
    }

    public void goneView(View view) {
        if (extraswitch.equals("0")) {
            view.setVisibility(View.GONE);
        }
    }

    public void loadintertialads(Activity activity) {
        appOpenContext = activity;

        MobileAds.initialize(activity, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(activity, GOOGLE_I, adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(InterstitialAd interstitialAd) {
                interstitial = interstitialAd;
                interstitial.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        super.onAdFailedToShowFullScreenContent(adError);

                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent();
                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent();
                        if (myCallback != null) {
                            myCallback.callbackCall();
                            Inter_Ads_Manager.this.myCallback = null;
                            adRequest = new AdRequest.Builder().build();
                        }

                    }
                });
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                // Handle the error
                interstitial = null;
                adRequest = new AdRequest.Builder().build();
            }

        });
    }

    public void displayInterstitial(Activity activity, MyCallback myCallback2) {

        Log.e("@@inter", "displayInterstitial..");

        this.myCallback = myCallback2;
        getInstance();
        if (adSwitch.equals("1")) {
            adIndex++;
            if (adIndex % Integer.parseInt(counter) == 0) {

                Log.e("@@inter", "if--1");
                if (AdsType.equals("0")) {
                    Log.e("@@inter", "if--2");
                    if (interstitial != null && !interstitial.equals("")) {
                        Log.e("@@inter", "if--3");
                        this.interstitial.show(activity);

                        //todo: custom loader..
                        Inter_Ads_Manager.getInstance().loadintertialads(activity);
                    } else {
                        Log.e("@@inter", "else--1");
                        MyCallback myCallback7 = this.myCallback;
                        if (myCallback7 != null) {
                            myCallback7.callbackCall();
                            this.myCallback = null;
                        }
                    }
                } else if (AdsType.equals("1")) {
                    Log.e("@@inter", "else if--1");
                    progressDialog = new ProgressDialog(activity, R.style.MyAlertDialogStyle);
                    progressDialog.setMessage("Loading Ads...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    final MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(APPLOVIN_I, activity);
                    maxInterstitialAd.setListener(new MaxAdListener() {
                        @Override
                        public void onAdLoaded(MaxAd ad) {

                            if (maxInterstitialAd.isReady()) {
                                progressDialog.dismiss();
                                maxInterstitialAd.showAd();
                            } else {
                                progressDialog.dismiss();
                                if (myCallback2 != null) {
                                    myCallback2.callbackCall();
                                    Inter_Ads_Manager.this.myCallback = null;
                                }
                            }
                        }

                        @Override
                        public void onAdDisplayed(MaxAd ad) {
                        }

                        @Override
                        public void onAdHidden(MaxAd ad) {
                            progressDialog.dismiss();
                            if (myCallback2 != null) {
                                myCallback2.callbackCall();
                                Inter_Ads_Manager.this.myCallback = null;
                            }

                        }

                        @Override
                        public void onAdClicked(MaxAd ad) {

                        }

                        @Override
                        public void onAdLoadFailed(String adUnitId, MaxError error) {
                            progressDialog.dismiss();
                            if (myCallback2 != null) {
                                myCallback2.callbackCall();
                                Inter_Ads_Manager.this.myCallback = null;
                            }
                        }

                        @Override
                        public void onAdDisplayFailed(MaxAd ad, MaxError error) {


                        }
                    });
                    maxInterstitialAd.loadAd();


                } else if (AdsType.equals("2")) {

                    adCounterInterstitial++;
                    if (adCounterInterstitial % 2 == 0) {
                        if (interstitial != null && !interstitial.equals("")) {
                            this.interstitial.show(activity);
                        } else {
                            MyCallback myCallback7 = this.myCallback;
                            if (myCallback7 != null) {
                                myCallback7.callbackCall();
                                this.myCallback = null;
                            }
                        }
                    } else {

                        progressDialog = new ProgressDialog(activity, R.style.MyAlertDialogStyle);
                        progressDialog.setMessage("Loading Ads...");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                        final MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(APPLOVIN_I, activity);
                        maxInterstitialAd.setListener(new MaxAdListener() {
                            @Override
                            public void onAdLoaded(MaxAd ad) {

                                if (maxInterstitialAd.isReady()) {
                                    progressDialog.dismiss();
                                    maxInterstitialAd.showAd();
                                } else {
                                    progressDialog.dismiss();
                                    if (myCallback2 != null) {
                                        myCallback2.callbackCall();
                                        Inter_Ads_Manager.this.myCallback = null;
                                    }
                                }
                            }

                            @Override
                            public void onAdDisplayed(MaxAd ad) {


                            }

                            @Override
                            public void onAdHidden(MaxAd ad) {
                                progressDialog.dismiss();
                                if (myCallback2 != null) {
                                    myCallback2.callbackCall();
                                    Inter_Ads_Manager.this.myCallback = null;
                                }

                            }

                            @Override
                            public void onAdClicked(MaxAd ad) {

                            }

                            @Override
                            public void onAdLoadFailed(String adUnitId, MaxError error) {
                                progressDialog.dismiss();
                                if (myCallback2 != null) {
                                    myCallback2.callbackCall();
                                    Inter_Ads_Manager.this.myCallback = null;
                                }
                            }

                            @Override
                            public void onAdDisplayFailed(MaxAd ad, MaxError error) {


                            }
                        });
                        maxInterstitialAd.loadAd();
                    }
                } else if (AdsType.equals("3")) {
                    if (myCallback2 != null) {
                        myCallback2.callbackCall();
                        Inter_Ads_Manager.this.myCallback = null;
                    }
                    Inter_Ads_Manager.getInstance().openChromeCustomTabUrl2(activity);
                }
            } else {
                if (myCallback2 != null) {
                    myCallback2.callbackCall();
                    Inter_Ads_Manager.this.myCallback = null;
                }
            }
        } else {
            if (myCallback2 != null) {
                myCallback2.callbackCall();
                Inter_Ads_Manager.this.myCallback = null;
            }
        }
    }

    public void splashInterstitial(Activity activity, MyCallback myCallback2) {
        this.myCallback = myCallback2;
        getInstance();
        if (adSwitch.equals("1")) {
            if (splashSwitch.equals("1")) {
                if (AdsType.equals("0")) {
                    if (interstitial != null && !interstitial.equals("")) {
                        this.interstitial.show(activity);
                    } else {
                        MyCallback myCallback7 = this.myCallback;
                        if (myCallback7 != null) {
                            myCallback7.callbackCall();
                            this.myCallback = null;
                        }
                    }
                } else if (AdsType.equals("1")) {

                    progressDialog = new ProgressDialog(activity, R.style.MyAlertDialogStyle);
                    progressDialog.setMessage("Loading Ads...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    final MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(APPLOVIN_I, activity);
                    maxInterstitialAd.setListener(new MaxAdListener() {
                        @Override
                        public void onAdLoaded(MaxAd ad) {

                            if (maxInterstitialAd.isReady()) {
                                progressDialog.dismiss();
                                maxInterstitialAd.showAd();
                            } else {
                                progressDialog.dismiss();
                                if (myCallback2 != null) {
                                    myCallback2.callbackCall();
                                    Inter_Ads_Manager.this.myCallback = null;
                                }
                            }
                        }

                        @Override
                        public void onAdDisplayed(MaxAd ad) {
                        }

                        @Override
                        public void onAdHidden(MaxAd ad) {
                            progressDialog.dismiss();
                            if (myCallback2 != null) {
                                myCallback2.callbackCall();
                                Inter_Ads_Manager.this.myCallback = null;
                            }

                        }

                        @Override
                        public void onAdClicked(MaxAd ad) {

                        }

                        @Override
                        public void onAdLoadFailed(String adUnitId, MaxError error) {
                            progressDialog.dismiss();
                            if (myCallback2 != null) {
                                myCallback2.callbackCall();
                                Inter_Ads_Manager.this.myCallback = null;
                            }
                        }

                        @Override
                        public void onAdDisplayFailed(MaxAd ad, MaxError error) {


                        }
                    });
                    maxInterstitialAd.loadAd();


                } else if (AdsType.equals("2")) {

                    adCounterInterstitial++;
                    if (adCounterInterstitial % 2 == 0) {
                        if (interstitial != null && !interstitial.equals("")) {
                            this.interstitial.show(activity);
                        } else {
                            MyCallback myCallback7 = this.myCallback;
                            if (myCallback7 != null) {
                                myCallback7.callbackCall();
                                this.myCallback = null;
                            }
                        }
                    } else {

                        progressDialog = new ProgressDialog(activity, R.style.MyAlertDialogStyle);
                        progressDialog.setMessage("Loading Ads...");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                        final MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(APPLOVIN_I, activity);
                        maxInterstitialAd.setListener(new MaxAdListener() {
                            @Override
                            public void onAdLoaded(MaxAd ad) {

                                if (maxInterstitialAd.isReady()) {
                                    progressDialog.dismiss();
                                    maxInterstitialAd.showAd();
                                } else {
                                    progressDialog.dismiss();
                                    if (myCallback2 != null) {
                                        myCallback2.callbackCall();
                                        Inter_Ads_Manager.this.myCallback = null;
                                    }
                                }
                            }

                            @Override
                            public void onAdDisplayed(MaxAd ad) {


                            }

                            @Override
                            public void onAdHidden(MaxAd ad) {
                                progressDialog.dismiss();
                                if (myCallback2 != null) {
                                    myCallback2.callbackCall();
                                    Inter_Ads_Manager.this.myCallback = null;
                                }

                            }

                            @Override
                            public void onAdClicked(MaxAd ad) {

                            }

                            @Override
                            public void onAdLoadFailed(String adUnitId, MaxError error) {
                                progressDialog.dismiss();
                                if (myCallback2 != null) {
                                    myCallback2.callbackCall();
                                    Inter_Ads_Manager.this.myCallback = null;
                                }
                            }

                            @Override
                            public void onAdDisplayFailed(MaxAd ad, MaxError error) {


                            }
                        });
                        maxInterstitialAd.loadAd();
                    }

                } else if (AdsType.equals("3")) {
                    if (myCallback2 != null) {
                        myCallback2.callbackCall();
                        Inter_Ads_Manager.this.myCallback = null;
                    }
                    Inter_Ads_Manager.getInstance().openChromeCustomTabUrl2(activity);

                } else {
                    if (myCallback2 != null) {
                        myCallback2.callbackCall();
                        Inter_Ads_Manager.this.myCallback = null;
                    }
                }
            } else {
                if (myCallback2 != null) {
                    myCallback2.callbackCall();
                    Inter_Ads_Manager.this.myCallback = null;
                }
            }
        } else {
            if (myCallback2 != null) {
                myCallback2.callbackCall();
                Inter_Ads_Manager.this.myCallback = null;
            }
        }
    }

    public void imgdisplayInterstitial(Activity activity, MyCallback myCallback2) {
        nativetvadIndex++;
        this.myCallback = myCallback2;
        getInstance();

        if (nativetvadIndex % Integer.parseInt(native_counter) == 0) {
            if (AdsType.equals("0")) {
                if (interstitial != null && !interstitial.equals("")) {
                    this.interstitial.show(activity);
                } else {
                    MyCallback myCallback7 = this.myCallback;
                    if (myCallback7 != null) {
                        myCallback7.callbackCall();
                        this.myCallback = null;
                    }
                }
            } else if (AdsType.equals("1")) {

                progressDialog = new ProgressDialog(activity, R.style.MyAlertDialogStyle);
                progressDialog.setMessage("Loading Ads...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                final MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(APPLOVIN_I, activity);
                maxInterstitialAd.setListener(new MaxAdListener() {
                    @Override
                    public void onAdLoaded(MaxAd ad) {

                        if (maxInterstitialAd.isReady()) {
                            progressDialog.dismiss();
                            maxInterstitialAd.showAd();
                        } else {
                            progressDialog.dismiss();
                            if (myCallback2 != null) {
                                myCallback2.callbackCall();
                                Inter_Ads_Manager.this.myCallback = null;
                            }
                        }
                    }

                    @Override
                    public void onAdDisplayed(MaxAd ad) {
                    }

                    @Override
                    public void onAdHidden(MaxAd ad) {
                        progressDialog.dismiss();
                        if (myCallback2 != null) {
                            myCallback2.callbackCall();
                            Inter_Ads_Manager.this.myCallback = null;
                        }

                    }

                    @Override
                    public void onAdClicked(MaxAd ad) {

                    }

                    @Override
                    public void onAdLoadFailed(String adUnitId, MaxError error) {
                        progressDialog.dismiss();
                        if (myCallback2 != null) {
                            myCallback2.callbackCall();
                            Inter_Ads_Manager.this.myCallback = null;
                        }
                    }

                    @Override
                    public void onAdDisplayFailed(MaxAd ad, MaxError error) {


                    }
                });
                maxInterstitialAd.loadAd();


            } else if (AdsType.equals("2")) {

                adCounterInterstitial++;
                if (adCounterInterstitial % 2 == 0) {
                    if (interstitial != null && !interstitial.equals("")) {
                        this.interstitial.show(activity);
                    } else {
                        MyCallback myCallback7 = this.myCallback;
                        if (myCallback7 != null) {
                            myCallback7.callbackCall();
                            this.myCallback = null;
                        }
                    }
                } else {

                    progressDialog = new ProgressDialog(activity, R.style.MyAlertDialogStyle);
                    progressDialog.setMessage("Loading Ads...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    final MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd(APPLOVIN_I, activity);
                    maxInterstitialAd.setListener(new MaxAdListener() {
                        @Override
                        public void onAdLoaded(MaxAd ad) {

                            if (maxInterstitialAd.isReady()) {
                                progressDialog.dismiss();
                                maxInterstitialAd.showAd();
                            } else {
                                progressDialog.dismiss();
                                if (myCallback2 != null) {
                                    myCallback2.callbackCall();
                                    Inter_Ads_Manager.this.myCallback = null;
                                }
                            }
                        }

                        @Override
                        public void onAdDisplayed(MaxAd ad) {


                        }

                        @Override
                        public void onAdHidden(MaxAd ad) {
                            progressDialog.dismiss();
                            if (myCallback2 != null) {
                                myCallback2.callbackCall();
                                Inter_Ads_Manager.this.myCallback = null;
                            }

                        }

                        @Override
                        public void onAdClicked(MaxAd ad) {

                        }

                        @Override
                        public void onAdLoadFailed(String adUnitId, MaxError error) {
                            progressDialog.dismiss();
                            if (myCallback2 != null) {
                                myCallback2.callbackCall();
                                Inter_Ads_Manager.this.myCallback = null;
                            }
                        }

                        @Override
                        public void onAdDisplayFailed(MaxAd ad, MaxError error) {


                        }
                    });
                    maxInterstitialAd.loadAd();
                }

            }
        } else {
            if (myCallback2 != null) {
                myCallback2.callbackCall();
                Inter_Ads_Manager.this.myCallback = null;
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void adaptivebanner(Activity activity, final FrameLayout frameLayout) {
        MobileAds.setRequestConfiguration(
                new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("ABCDEF012345")).build());
        if (adSwitch.equals("1")) {
            if (AdsType.equals("0")) {
                adView = new AdView(activity);
                adView.setAdUnitId(GOOGLE_B);
                frameLayout.removeAllViews();
                frameLayout.addView(adView);

                AdSize adSize = getAdSize(activity, frameLayout);
                adView.setAdSize(adSize);
                frameLayout.setVisibility(View.VISIBLE);
                AdRequest adRequest = new AdRequest.Builder().build();
                adView.loadAd(adRequest);
            } else if (AdsType.equals("1")) {
                if (APPLOVIN_B.equals("000")) {
                    frameLayout.setVisibility(View.GONE);
                } else {
                    MaxAdView adView = new MaxAdView(APPLOVIN_B, activity);
                    adView.setListener(new MaxAdViewAdListener() {
                        @Override
                        public void onAdExpanded(MaxAd ad) {

                        }

                        @Override
                        public void onAdCollapsed(MaxAd ad) {

                        }

                        @Override
                        public void onAdLoaded(MaxAd ad) {
                            frameLayout.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAdDisplayed(MaxAd ad) {

                        }

                        @Override
                        public void onAdHidden(MaxAd ad) {


                        }

                        @Override
                        public void onAdClicked(MaxAd ad) {

                        }

                        @Override
                        public void onAdLoadFailed(String adUnitId, MaxError error) {
                            frameLayout.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAdDisplayFailed(MaxAd ad, MaxError error) {

                        }
                    });
                    final boolean isTablet = AppLovinSdkUtils.isTablet(activity);
                    final int heightPx = AppLovinSdkUtils.dpToPx(activity, isTablet ? 90 : 50);
                    adView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightPx));
                    frameLayout.addView(adView);
                    adView.loadAd();
                }
            } else if (AdsType.equals("2")) {
                adCounterBanner++;
                if (adCounterBanner % 2 == 0) {
                    adView = new AdView(activity);
                    adView.setAdUnitId(GOOGLE_B);
                    frameLayout.removeAllViews();
                    frameLayout.addView(adView);

                    AdSize adSize = getAdSize(activity, frameLayout);
                    adView.setAdSize(adSize);
                    frameLayout.setVisibility(View.VISIBLE);
                    AdRequest adRequest = new AdRequest.Builder().build();
                    adView.loadAd(adRequest);
                } else {
                    if (APPLOVIN_B.equals("000")) {
                        frameLayout.setVisibility(View.GONE);
                    } else {
                        MaxAdView adView = new MaxAdView(APPLOVIN_B, activity);
                        adView.setListener(new MaxAdViewAdListener() {
                            @Override
                            public void onAdExpanded(MaxAd ad) {

                            }

                            @Override
                            public void onAdCollapsed(MaxAd ad) {

                            }

                            @Override
                            public void onAdLoaded(MaxAd ad) {
                                frameLayout.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onAdDisplayed(MaxAd ad) {

                            }

                            @Override
                            public void onAdHidden(MaxAd ad) {


                            }

                            @Override
                            public void onAdClicked(MaxAd ad) {

                            }

                            @Override
                            public void onAdLoadFailed(String adUnitId, MaxError error) {
                                frameLayout.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

                            }
                        });
                        final boolean isTablet = AppLovinSdkUtils.isTablet(activity);
                        final int heightPx = AppLovinSdkUtils.dpToPx(activity, isTablet ? 90 : 50);
                        adView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, heightPx));
                        frameLayout.addView(adView);
                        adView.loadAd();
                    }
                }
            } else if (AdsType.equals("3")) {
                View child = activity.getLayoutInflater().inflate(R.layout.pro_one, null);
                frameLayout.addView(child);
                ImageView icon = child.findViewById(R.id.icon);


                frameLayout.setVisibility(View.VISIBLE);

                frameLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openChromeCustomTabUrl(activity);
                    }
                });
            }
        }
    }

    private AdSize getAdSize(Activity activity, FrameLayout linearLayout) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = outMetrics.density;

        float adWidthPixels = linearLayout.getWidth();

        if (adWidthPixels == 0) {
            adWidthPixels = outMetrics.widthPixels;
        }

        int adWidth = (int) (adWidthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth);
    }

    @SuppressLint("MissingPermission")
    public void refreshAd(final Activity activity, final FrameLayout frameLayout) {
        if (adSwitch.equals("1")) {
            if (AdsType.equals("0")) {
                AdLoader.Builder builder = new AdLoader.Builder(activity, GOOGLE_N);
                builder.forNativeAd(new com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(com.google.android.gms.ads.nativead.NativeAd nativeAd) {
                        NativeAdView adView =
                                (NativeAdView) activity.getLayoutInflater().inflate(R.layout.pro_three, null);
                        populateUnifiedNativeAdView(nativeAd, adView);

                        frameLayout.removeAllViews();
                        frameLayout.addView(adView);
                        frameLayout.setVisibility(View.VISIBLE);
                    }
                });

                AdLoader adLoader = builder.withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {

                    }
                }).build();

                adLoader.loadAd(new AdRequest.Builder().build());
            } else if (AdsType.equals("1")) {
                if (APPLOVIN_N.equals("000")) {
                    frameLayout.setVisibility(View.GONE);
                } else {
                    MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader(APPLOVIN_N, activity);
                    nativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                        @Override
                        public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad) {
                            frameLayout.removeAllViews();
                            frameLayout.addView(nativeAdView);
                            frameLayout.setVisibility(View.VISIBLE);

                            //todo: applovin native size
                            frameLayout.getLayoutParams().height = 750;
                            frameLayout.requestLayout();
                        }

                        @Override
                        public void onNativeAdLoadFailed(final String adUnitId, final MaxError error) {
                            frameLayout.setVisibility(View.GONE);
                        }

                        @Override
                        public void onNativeAdClicked(final MaxAd ad) {

                        }
                    });

                    nativeAdLoader.loadAd();
                }
            } else if (AdsType.equals("2")) {
                adCounterNative++;
                if (adCounterNative % 2 == 0) {
                    AdLoader.Builder builder = new AdLoader.Builder(activity, GOOGLE_N);

                    builder.forNativeAd(new com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(com.google.android.gms.ads.nativead.NativeAd nativeAd) {
                            NativeAdView adView =
                                    (NativeAdView) activity.getLayoutInflater().inflate(R.layout.pro_three, null);
                            populateUnifiedNativeAdView(nativeAd, adView);

                            frameLayout.removeAllViews();
                            frameLayout.addView(adView);
                            frameLayout.setVisibility(View.VISIBLE);
                        }
                    });

                    AdLoader adLoader = builder.withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError loadAdError) {

                        }
                    }).build();

                    adLoader.loadAd(new AdRequest.Builder().build());
                } else {
                    if (APPLOVIN_N.equals("000")) {
                        frameLayout.setVisibility(View.GONE);
                    } else {
                        MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader(APPLOVIN_N, activity);
                        nativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                            @Override
                            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad) {
                                frameLayout.removeAllViews();
                                frameLayout.addView(nativeAdView);
                                frameLayout.setVisibility(View.VISIBLE);

                                //todo: applovin native size
                                frameLayout.getLayoutParams().height = 750;
                                frameLayout.requestLayout();
                            }

                            @Override
                            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error) {
                                frameLayout.setVisibility(View.GONE);
                            }

                            @Override
                            public void onNativeAdClicked(final MaxAd ad) {

                            }
                        });

                        nativeAdLoader.loadAd();
                    }
                }
            } else if (AdsType.equals("3")) {
                View child = activity.getLayoutInflater().inflate(R.layout.pro_two, null);
                frameLayout.addView(child);
                frameLayout.setVisibility(View.VISIBLE);
                ImageView imageNative = child.findViewById(R.id.imageNative);

                frameLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openChromeCustomTabUrl(v.getContext());
                    }
                });
            }
        }
    }

    private void populateUnifiedNativeAdView(com.google.android.gms.ads.nativead.NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView(adView.findViewById(R.id.ad_media));

        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());

        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            adView.getIconView().setVisibility(View.VISIBLE);
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
        }


        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

        adView.setNativeAd(nativeAd);

        VideoController vc = nativeAd.getMediaContent().getVideoController();

        if (vc.hasVideoContent()) {
            vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                @Override
                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
        }
    }

    public void shareApp(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", R.string.app_name);
            intent.putExtra("android.intent.extra.TEXT", "\nLet me recommend you this MYApplication\n\n" + "https://play.google.com/store/apps/details?id=" + context.getPackageName() + "\n\n");
            context.startActivity(Intent.createChooser(intent, "choose one"));
        } catch (Exception unused) {
            unused.printStackTrace();
        }
    }


    public void rateUs(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }
    }


    public void openChromeCustomTabUrl(Context context) {


        try {
            if (isAppInstalled("com.android.chrome", context)) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                int coolorInt = Color.parseColor("#64BDFF");
                builder.setToolbarColor(coolorInt);
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.intent.setPackage("com.android.chrome");
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(context, Uri.parse(qurekaLink));
            } else {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                int coolorInt = Color.parseColor("#64BDFF");
                builder.setToolbarColor(coolorInt);
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                customTabsIntent.launchUrl(context, Uri.parse(qurekaLink));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void openChromeCustomTabUrl2(Context context) {

        if (other3.equals("ek")) {
            openChromeCustomTabUrl(context);
        } else {
            openChromeCustomTabUrl(context);
            try {
                if (isAppInstalled("com.android.chrome", context)) {
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    int coolorInt = Color.parseColor("#64BDFF");
                    builder.setToolbarColor(coolorInt);
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.intent.setPackage("com.android.chrome");
                    customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    customTabsIntent.launchUrl(context, Uri.parse(qurekaLink));

                } else {
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    int coolorInt = Color.parseColor("#64BDFF");
                    builder.setToolbarColor(coolorInt);
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    customTabsIntent.launchUrl(context, Uri.parse(qurekaLink));

                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(context, "false", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isAppInstalled(String uri, Context context) {
        PackageManager pm = context.getPackageManager();
        boolean installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }

    public interface MyCallback {
        void callbackCall();
    }

}
