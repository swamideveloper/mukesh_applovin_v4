package com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eight.mukesh_four_ghima;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eight.mukesh_four_bappa;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eight.mukesh_four_ganpati;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eight.mukesh_four_morya;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.MyApp;


public class mukesh_four_ke extends MyApp {
    public static final String TAG = "MyApplicationClass";
    public static mukesh_four_ke mukesh_four_ke;
    public static Context context = null;
    public static mukesh_four_morya SFLoanDB = null;
    public static mukesh_four_ghima SFLoanTPPP;
    private RequestQueue mRequestQueue;


    public static synchronized mukesh_four_ke getInstance() {
        mukesh_four_ke SFLoanMBit;
        synchronized (mukesh_four_ke.class) {
            SFLoanMBit = mukesh_four_ke;
        }
        return SFLoanMBit;
    }

    public static Context getContext() {
        return context;
    }

    public void onCreate() {
        super.onCreate();
        mukesh_four_ke = this;
        context = getApplicationContext();
        mukesh_four_ganpati.sharedPreferences();
        if (!mukesh_four_ganpati.sharedPreferences().contains("spin")) {
            mukesh_four_ganpati.editorString("spin", mukesh_four_ganpati.SPIN);
        }
        SFLoanDB = new mukesh_four_morya(getApplicationContext());
        mukesh_four_bappa.setDefaultFont(this, "DEFAULT", "fonts/MyFont.ttf");
        mukesh_four_bappa.setDefaultFont(this, "MONOSPACE", "fonts/MyFont.ttf");
        mukesh_four_bappa.setDefaultFont(this, "SERIF", "fonts/MyFont.ttf");
        mukesh_four_bappa.setDefaultFont(this, "SANS_SERIF", "fonts/MyFont.ttf");
    }

    public RequestQueue getRequestQueue() {
        if (this.mRequestQueue == null) {
            this.mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return this.mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request, String str) {
        if (TextUtils.isEmpty(str)) {
            str = TAG;
        }
        request.setTag(str);
        getRequestQueue().add(request);
    }


}
