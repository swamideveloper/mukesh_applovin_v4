package com.fastcash.speedloancoach.quickloan.mukesh_pkg_two;

import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mCountry;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mExitDialoge;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mPrivacy;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mThankYou;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;


public class mukesh_four_bhav extends AppCompatActivity {


    RecyclerView rvLeng;
    int[] ints = new int[]{R.drawable.leng1, R.drawable.leng2, R.drawable.leng3, R.drawable.leng4, R.drawable.leng5, R.drawable.leng6};
    //back------------------------------------------------------------------------------------------
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mukesh_four_o);

        Inter_Ads_Manager.getInstance().adaptivebanner(this, findViewById(R.id.native_container));


        if (getIntent().getBooleanExtra("app_inter", false)) {
            
            Inter_Ads_Manager.getInstance().displayInterstitial(this, new Inter_Ads_Manager.MyCallback() {
                @Override
                public void callbackCall() {
                }
            });
        }


        init();
    }

    private void init() {
        rvLeng = findViewById(R.id.rvLeng);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvLeng.setLayoutManager(gridLayoutManager);
        mukesh_four_prusti appLanguageAdapter = new mukesh_four_prusti(this, ints);
        rvLeng.setAdapter(appLanguageAdapter);
    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

        if (mPrivacy.equalsIgnoreCase("on")) {
            startActivity(new Intent(context, mukesh_four_sungndhim.class).putExtra("app_inter", true));
            finish();
        } else if (mCountry.equalsIgnoreCase("on")) {
            startActivity(new Intent(context, mukesh_four_mahe.class).putExtra("app_inter", true));
            finish();
        } else {
            if (mExitDialoge.equalsIgnoreCase("on")) {
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.mukesh_four_oct);
                dialog.setCancelable(true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                Window window = dialog.getWindow();
                WindowManager.LayoutParams wlp = window.getAttributes();
                dialog.setCancelable(true);
                wlp.gravity = Gravity.BOTTOM;
                window.setAttributes(wlp);

                Inter_Ads_Manager.getInstance().refreshAd(this, dialog.findViewById(R.id.native_container));

                TextView txt_yes = dialog.findViewById(R.id.yes);
                txt_yes.setOnClickListener(v -> {
                    dialog.dismiss();
                    if (mThankYou.equalsIgnoreCase("on")) {
                        startActivity(new Intent(this, mukesh_four_yaja.class).putExtra("app_inter", true));
                    } else {
                        finishAffinity();
                    }
                });
                dialog.show();
            } else {
                if (doubleBackToExitPressedOnce) {
                    ((Activity) context).finishAffinity();
                    System.exit(1);
                    return;
                }

                doubleBackToExitPressedOnce = true;
                Toast.makeText(context, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            }
        }
    }
}
