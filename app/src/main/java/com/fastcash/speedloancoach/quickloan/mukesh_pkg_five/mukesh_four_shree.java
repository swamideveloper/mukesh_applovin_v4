package com.fastcash.speedloancoach.quickloan.mukesh_pkg_five;

import android.content.Context;
import android.net.ConnectivityManager;

public class mukesh_four_shree {
    public static int click = 1;
    public static int gclick = 0;
    public static String privacy = null;


//    public static boolean isNetworkAvailable(Activity activity) {
//        NetworkInfo activeNetworkInfo = ((ConnectivityManager) activity.getSystemService("connectivity")).getActiveNetworkInfo();
//        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
