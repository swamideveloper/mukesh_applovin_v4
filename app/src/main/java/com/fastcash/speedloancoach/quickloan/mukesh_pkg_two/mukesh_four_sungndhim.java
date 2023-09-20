package com.fastcash.speedloancoach.quickloan.mukesh_pkg_two;

import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mCountry;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mExitDialoge;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mLanguage;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mPermission;
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
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;


public class mukesh_four_sungndhim extends AppCompatActivity {


    TextView tvAccept, textView, iv_close;
    TextView tv_policy1, tv_policy2, tv_policy3, tv_diffaccept;

    //back------------------------------------------------------------------------------------------
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mukesh_four_q);

        Inter_Ads_Manager.getInstance().adaptivebanner(this, findViewById(R.id.native_container));
        if (getIntent().getBooleanExtra("app_inter", false)) {
            
            Inter_Ads_Manager.getInstance().displayInterstitial(this, new Inter_Ads_Manager.MyCallback() {
                @Override
                public void callbackCall() {
                }
            });
        }


        init();

        String str1 = "Following link :" + " <a href=\"https://androidappsforplaystore.blogspot.com/2022/09/terms-conditions.html\"> <b> Terms and conditions of use </b> </a> ";
        tv_policy1.setText(Html.fromHtml(str1));
        tv_policy1.setLinkTextColor(getResources().getColor(R.color.blue));
        tv_policy1.setMovementMethod(LinkMovementMethod.getInstance());

        String str2 = "Following Link :" + " <a href=\"https://androidappsforplaystore.blogspot.com/2022/09/privacy-policy.html\"> <b> Privacy policy </b> </a> ";
        tv_policy2.setText(Html.fromHtml(str2));
        tv_policy2.setLinkTextColor(getResources().getColor(R.color.blue));
        tv_policy2.setMovementMethod(LinkMovementMethod.getInstance());

        String str3 = "Following Link :" + " <a href=\"https://androidappsforplaystore.blogspot.com/2022/09/app-community-guidelines.html\"> <b> App Community Guidelines </b> </a> ";
        tv_policy3.setText(Html.fromHtml(str3));
        tv_policy3.setLinkTextColor(getResources().getColor(R.color.blue));
        tv_policy3.setMovementMethod(LinkMovementMethod.getInstance());

        iv_close.setOnClickListener(v -> onBackPressed());

        tvAccept.setOnClickListener(v -> {
            if (mLanguage.equalsIgnoreCase("on")) {
                startActivity(new Intent(mukesh_four_sungndhim.this, mukesh_four_bhav.class).putExtra("app_inter", true));
            } else if (mPermission.equalsIgnoreCase("on")) {
                startActivity(new Intent(mukesh_four_sungndhim.this, mukesh_four_rupe.class).putExtra("app_inter", true));
            } else if (mStart.equalsIgnoreCase("on")) {
                startActivity(new Intent(mukesh_four_sungndhim.this, mukesh_four_bardhanam.class).putExtra("app_inter", true));
            } else {
                startActivity(new Intent(mukesh_four_sungndhim.this, new mukesh_four_bhi().activity_X).putExtra("app_inter", true));
            }
        });
    }

    private void init() {
        iv_close = findViewById(R.id.iv_close);
        tvAccept = findViewById(R.id.tvText);
        textView = findViewById(R.id.textView);
        tv_policy1 = findViewById(R.id.tv_policy1);
        tv_policy2 = findViewById(R.id.tv_policy2);
        tv_policy3 = findViewById(R.id.tv_policy3);
        tv_diffaccept = findViewById(R.id.tv_diffaccept);
    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

        if (mCountry.equalsIgnoreCase("on")) {
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
