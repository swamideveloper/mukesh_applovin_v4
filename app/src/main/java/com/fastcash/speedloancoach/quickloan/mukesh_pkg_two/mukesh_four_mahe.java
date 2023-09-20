package com.fastcash.speedloancoach.quickloan.mukesh_pkg_two;

import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mExitDialoge;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mLanguage;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mPermission;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mPrivacy;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mStart;
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

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;

import java.util.ArrayList;

public class mukesh_four_mahe extends AppCompatActivity {

    RecyclerView rvV;
    ArrayList<mukesh_four_tramkakam> loaned_F_Loan_MCS;

    //back------------------------------------------------------------------------------------------
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mukesh_four_m);

        Inter_Ads_Manager.getInstance().adaptivebanner(this, findViewById(R.id.native_container));


        if (getIntent().getBooleanExtra("app_inter", false)) {
            
            Inter_Ads_Manager.getInstance().displayInterstitial(this, new Inter_Ads_Manager.MyCallback() {
                @Override
                public void callbackCall() {
                }
            });
        }


        addData();
        init();
    }

    private void addData() {
        loaned_F_Loan_MCS = new ArrayList<>();
        loaned_F_Loan_MCS.add(new mukesh_four_tramkakam("United Kingdom", "gb", R.drawable.uk));
        loaned_F_Loan_MCS.add(new mukesh_four_tramkakam("United States", "us", R.drawable.us));
        loaned_F_Loan_MCS.add(new mukesh_four_tramkakam("Canada", "ca", R.drawable.canada));
        loaned_F_Loan_MCS.add(new mukesh_four_tramkakam("Australia", "au", R.drawable.au));
        loaned_F_Loan_MCS.add(new mukesh_four_tramkakam("Switzerland", "ch", R.drawable.ch));
        loaned_F_Loan_MCS.add(new mukesh_four_tramkakam("World Wide", "all", R.drawable.globalcall));
    }

    private void init() {
        rvV = findViewById(R.id.rvV);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvV.setLayoutManager(gridLayoutManager);

        mukesh_four_hirva countryAdapter = new mukesh_four_hirva(this, loaned_F_Loan_MCS, new mukesh_four_om() {
            @Override
            public void callback(String code) {
                if (mPrivacy.equalsIgnoreCase("on")) {
                    startActivity(new Intent(mukesh_four_mahe.this, mukesh_four_sungndhim.class).putExtra("app_inter", true));
                } else if (mLanguage.equalsIgnoreCase("on")) {
                    startActivity(new Intent(mukesh_four_mahe.this, mukesh_four_bhav.class).putExtra("app_inter", true));
                } else if (mPermission.equalsIgnoreCase("on")) {
                    startActivity(new Intent(mukesh_four_mahe.this, mukesh_four_rupe.class).putExtra("app_inter", true));
                } else if (mStart.equalsIgnoreCase("on")) {
                    startActivity(new Intent(mukesh_four_mahe.this, mukesh_four_bardhanam.class).putExtra("app_inter", true));
                } else {
                    startActivity(new Intent(mukesh_four_mahe.this, new mukesh_four_bhi().activity_X).putExtra("app_inter", true));
                }
            }
        });

        rvV.setAdapter(countryAdapter);
    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

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
