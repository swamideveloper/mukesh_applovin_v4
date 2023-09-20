package com.fastcash.speedloancoach.quickloan.mukesh_pkg_thirteen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_seven.mukesh_four_kya;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_five.mukesh_four_shree;


@SuppressLint("WrongConstant")

public class mukesh_four_teri extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ActInstantCash";

    public Activity activity;
    public int f46i = 0;
    TextView tvTitle;
    ImageView ivBack;
    ProgressDialog progressBar;
    ProgressDialog progressDialog;
    private TextView btnApplyNow;
    private Intent intent;

    private boolean isOnline() {
        @SuppressLint({"MissingPermission", "WrongConstant"}) NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_t);


        
        Inter_Ads_Manager.getInstance().displayInterstitial(this, new Inter_Ads_Manager.MyCallback() {
            @Override
            public void callbackCall() {
            }
        });
        Inter_Ads_Manager.getInstance().refreshAd(this, findViewById(R.id.adsContainer));


        progressDialog = new ProgressDialog(this);
        if (isOnline()) {
            progressDialog.setTitle("Loading Data");
            progressDialog.setMessage("Please Wait a second");
            progressDialog.hide();
            new Handler().postDelayed(new Runnable() {

                public void run() {
                    mukesh_four_teri.this.progressDialog.isShowing();
                    mukesh_four_teri.this.progressDialog.dismiss();
                }
            }, 3000);
        }
        activity = this;
        TextView button = (TextView) findViewById(R.id.btnApplyNow);
        btnApplyNow = button;
        button.setOnClickListener(this);

        ivBack = findViewById(R.id.id_ivBack);
        tvTitle = findViewById(R.id.id_tvTitle);

        ivBack.setOnClickListener(v -> onBackPressed());
        tvTitle.setText("Loan Amount");

    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnApplyNow) {
            mukesh_four_shree.gclick++;
            if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                ironfullscreen(1);
            } else {
                click(1);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void ironfullscreen(final int i) {
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        progressBar = progressDialog2;
        progressDialog2.setCancelable(false);
        progressBar.setMessage("Ads Loading ...");
        progressBar.setProgressStyle(0);
        progressBar.show();
        mukesh_four_teri.this.progressBar.dismiss();
        mukesh_four_teri.this.click(i);
    }

    public void click(int i) {
        if (i == 1) {
            Intent intent2 = new Intent(this.activity, mukesh_four_kya.class);
            intent = intent2;
            startActivity(intent2);
        } else if (i == 2) {
            startActivity(new Intent(this, mukesh_four_ka.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //back--ads--not--found
    }
}
