package com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine;

import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_ten.pro_eight.getGeoApiService;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.MyApp;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.OpenAds;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_two.mukesh_four_mahe;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_two.mukesh_four_sungndhim;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_two.mukesh_four_bardhanam;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_two.mukesh_four_bhav;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_two.mukesh_four_rupe;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_six.pro_one;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_six.pro_five;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_six.pro_three;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_six.pro_two;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_ten.pro_six;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_ten.pro_seven;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_thirteen.mukesh_four_ka;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_fourteen.mukesh_four_he;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_fourteen.mukesh_four_jis;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mukesh_four_bhi extends AppCompatActivity {


    //sdk static
    public static String GOOGLE_B = "000";
    public static String GOOGLE_N = "000";
    public static String GOOGLE_I = "000";
    public static String GOOGLE_AO = "000";
    public static String APPLOVIN_B = "000";
    public static String APPLOVIN_N = "000";
    public static String APPLOVIN_I = "000";
    public static String AdsType = "1";
    public static String counter = "1";
    public static String qurekaLink = "";
    public static String native_counter = "1";
    public static String extraswitch = "1";
    public static int adCounterBanner = 1;
    public static int adCounterNative = 1;
    public static int adCounterInterstitial = 1;
    public static String adSwitch = "0";
    public static String splashSwitch = "0";
    public static String other3 = "";
    //app screen var
    public static String mCountry = "off";
    public static String mPrivacy = "off";
    public static String mLanguage = "off";
    public static String mPermission = "off";
    public static String mStart = "off";
    public static String mThankYou = "off";
    public static String mExitDialoge = "off";
    //old sdk
    public static Class activity_X;
    static OpenAds firstAppOpenManager;
    public boolean excludeChecker = false;
    public boolean includeChecker = false;
    List<pro_three> mVar = new ArrayList<>();

    //verify
    String iType = "";
    int normal_Index = 0;
    int publisher_Index = 1;

    AlertDialog.Builder builder1;
    AlertDialog.Builder builder2;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_j);


        if (isNetworkConnected()) {
            mukesh_four_jis specialApiInterface = mukesh_four_he.getClient().create(mukesh_four_jis.class);
            Call<pro_one> call = specialApiInterface.getSdkData();
            call.enqueue(new Callback<pro_one>() {
                @Override
                public void onResponse(Call<pro_one> call, Response<pro_one> response) {

                    mVar = response.body().getAppVariables();

                    pro_two app_SFLoanSt = response.body().getSettings();
                    iType = app_SFLoanSt.getLocType();

                    if (iType.equalsIgnoreCase("include") || iType.equalsIgnoreCase("exclude")) {
                        verifyUser(app_SFLoanSt.getLocArray());
                    } else {
                        setVariables(normal_Index);
                    }

                }

                @Override
                public void onFailure(Call<pro_one> call, Throwable t) {
                    //Log.e("@@Trans", "onFailure: " + t.getMessage());
                }
            });
        } else {
            checkNetworkConnection();
        }
    }


    private void setVariables(int varIndex) {
        GOOGLE_B = mVar.get(varIndex).getGOOGLE_B();
        GOOGLE_I = mVar.get(varIndex).getGOOGLE_I();
        GOOGLE_N = mVar.get(varIndex).getGOOGLE_N();
        GOOGLE_AO = mVar.get(varIndex).getGOOGLE_AP();
        APPLOVIN_N = mVar.get(varIndex).getAPPLOVIN_N();
        APPLOVIN_I = mVar.get(varIndex).getAPPLOVIN_I();
        APPLOVIN_B = mVar.get(varIndex).getAPPLOVIN_B();
        native_counter = "1";
        counter = mVar.get(varIndex).getInter_Counter();
        qurekaLink = mVar.get(varIndex).getQureka_Link();
        adSwitch = mVar.get(varIndex).getAd_Flag();
        splashSwitch = mVar.get(varIndex).getAd_Splash();
        String adType = mVar.get(varIndex).getAd_Type();

        Log.e("@@printf", "GOOGLE_B: " + GOOGLE_B);
        Log.e("@@printf", "GOOGLE_I: " + GOOGLE_I);
        Log.e("@@printf", "GOOGLE_N: " + GOOGLE_N);
        Log.e("@@printf", "GOOGLE_AO: " + GOOGLE_AO);
        Log.e("@@printf", "APPLOVIN_N: " + APPLOVIN_N);
        Log.e("@@printf", "APPLOVIN_I: " + APPLOVIN_I);
        Log.e("@@printf", "APPLOVIN_B: " + APPLOVIN_B);
        Log.e("@@printf", "counter: " + counter);
        Log.e("@@printf", "qurekaLink: " + qurekaLink);
        Log.e("@@printf", "adSwitch: " + adSwitch);
        Log.e("@@printf", "adType: " + adType);

        mCountry = mVar.get(varIndex).getApp_Country();
        mPrivacy = mVar.get(varIndex).getApp_Privacy();
        mLanguage = mVar.get(varIndex).getApp_Language();
        mPermission = mVar.get(varIndex).getApp_Permission();
        mStart = mVar.get(varIndex).getApp_Start();
        mThankYou = mVar.get(varIndex).getApp_Thankyou();
        mExitDialoge = mVar.get(varIndex).getApp_Exit_Dialoge();


        Log.e("@@printf", "mCountry: " + mCountry);
        Log.e("@@printf", "mPrivacy: " + mPrivacy);
        Log.e("@@printf", "mLanguage: " + mLanguage);
        Log.e("@@printf", "mPermission: " + mPermission);
        Log.e("@@printf", "mStart: " + mStart);
        Log.e("@@printf", "mThankYou: " + mThankYou);
        Log.e("@@printf", "mExitDialoge: " + mExitDialoge);


        switch (adType) {
            case "admob":
                //admob
                AdsType = "0";
                break;
            case "applovin":
                //applovin
                AdsType = "1";
                break;
            case "url":
                //qureka
                AdsType = "3";
                break;
            default:
                //google-applovin mix
                AdsType = "2";
                break;
        }

        if (AdsType.matches("0")) {
            firstAppOpenManager = new OpenAds((MyApp) getApplication());
        }

        Inter_Ads_Manager.getInstance().splashInterstitial(mukesh_four_bhi.this, new Inter_Ads_Manager.MyCallback() {
            @Override
            public void callbackCall() {

                Inter_Ads_Manager.getInstance().loadintertialads(mukesh_four_bhi.this);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadAppScreen();
                    }
                }, 4000);
            }
        });

    }

    private void verifyUser(List<pro_five> iArray) {
        pro_seven apiService = getGeoApiService();
        apiService.getLocation().enqueue(new retrofit2.Callback<pro_six>() {
            @Override
            public void onResponse(Call<pro_six> call, Response<pro_six> response) {

                String uCountryCode = response.body().getCountryCode();
                String uStateCode = response.body().getRegion();
                String uCityName = response.body().getCity();


                switch (iType) {
                    case "include":
                        for (int k = 0; k < iArray.size(); k++) {
                            if (uCountryCode.equalsIgnoreCase(iArray.get(k).getCountryCode()) ||
                                    uStateCode.equalsIgnoreCase(iArray.get(k).getStateCode()) ||
                                    uCityName.equalsIgnoreCase(iArray.get(k).getCityName())) {
                                k = 999;
                                includeChecker = true;
                            }
                        }

                        if (includeChecker) {
                            setVariables(publisher_Index);
                            //Log.e("@@Trans", "exclude - Publisher...");
                        } else {
                            setVariables(normal_Index);
                            //Log.e("@@Trans", "exclude - Normal User...");
                        }
                        break;

                    case "exclude":
                        for (int j = 0; j < iArray.size(); j++) {
                            if (uCountryCode.equalsIgnoreCase(iArray.get(j).getCountryCode()) ||
                                    uStateCode.equalsIgnoreCase(iArray.get(j).getStateCode()) ||
                                    uCityName.equalsIgnoreCase(iArray.get(j).getCityName())) {
                                j = 999;
                                excludeChecker = true;
                            }
                        }

                        if (excludeChecker) {
                            setVariables(publisher_Index);
                            //Log.e("@@Trans", "include - Publisher...");
                        } else {
                            setVariables(normal_Index);
                            //Log.e("@@Trans", "include - Normal User...");
                        }
                        break;

                    default:
                        setVariables(normal_Index);
                        break;
                }
            }

            @Override
            public void onFailure(Call<pro_six> call, Throwable t) {
                //Log.e("@@Trans", "user verify api issue: " + t.getMessage());
                setVariables(normal_Index);
            }
        });
    }


    private void loadAppScreen() {

        activity_X = mukesh_four_ka.class;

        if (mCountry.equalsIgnoreCase("on")) {
            Intent i = new Intent(mukesh_four_bhi.this, mukesh_four_mahe.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (mPrivacy.equalsIgnoreCase("on")) {
            Intent i = new Intent(mukesh_four_bhi.this, mukesh_four_sungndhim.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (mLanguage.equalsIgnoreCase("on")) {
            Intent i = new Intent(mukesh_four_bhi.this, mukesh_four_bhav.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (mPermission.equalsIgnoreCase("on")) {
            Intent i = new Intent(mukesh_four_bhi.this, mukesh_four_rupe.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (mStart.equalsIgnoreCase("on")) {
            Intent i = new Intent(mukesh_four_bhi.this, mukesh_four_bardhanam.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else {
            Intent i = new Intent(mukesh_four_bhi.this, activity_X);
            i.putExtra("app_inter", false);
            startActivity(i);
        }
    }

    public boolean isDevMode() {
        if (Integer.valueOf(android.os.Build.VERSION.SDK) == 16) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(), android.provider.Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED, 0) != 0;
        } else if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 17) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(), android.provider.Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) != 0;
        } else return false;
    }


    public void checkNetworkConnection() {
        builder2 = new AlertDialog.Builder(this);
        builder2.setCancelable(false);
        builder2.setTitle("No internet Connection");
        builder2.setMessage("Please turn on internet connection to continue!");
        builder2.setPositiveButton("Turn On", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {
                mukesh_four_bhi.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                mukesh_four_bhi.this.finish();
            }
        }).show();
        builder2.setNegativeButton("Exit", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {
                mukesh_four_bhi.this.finishAffinity();
            }
        }).show();
        builder2.create().show();
    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}
