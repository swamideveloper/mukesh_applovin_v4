package com.fastcash.speedloancoach.quickloan.mukesh_pkg_three;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_five.mukesh_four_shree;

@SuppressLint("WrongConstant")

public class mukesh_four_kal extends AppCompatActivity {


    private static final String TAG = "ActLoanDetails";

    public Activity activity;
    public int f46i = 0;
    public Intent intent;
    ProgressDialog progressBar;
    ProgressDialog progressDialog;
    ImageView ivBack;
    private LinearLayout btnApplyForLoan;
    private TextView tvDescription;
    private TextView tvName, tvTitle;

    private boolean isOnline() {
        @SuppressLint("WrongConstant") NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_e);


        
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
                    mukesh_four_kal.this.progressDialog.isShowing();
                    mukesh_four_kal.this.progressDialog.dismiss();
                }
            }, 3000);
        }
        activity = this;
        tvTitle = findViewById(R.id.id_tvTitle);
        ivBack = findViewById(R.id.id_ivBack);
        ivBack.setOnClickListener(v -> onBackPressed());
        tvTitle.setText(R.string.personal_loan);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        btnApplyForLoan = (LinearLayout) findViewById(R.id.btnApplyForLoan);
        TextView textView = this.tvTitle;
        if (!com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP.getName().equals("")) {
            textView.setText(com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP.getName() + " Information");
        }
        tvDescription.setText(com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP.getDescription());
        btnApplyForLoan.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                mukesh_four_shree.gclick++;
                if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                    mukesh_four_kal.this.ironfullscreen(1);
                } else {
                    mukesh_four_kal.this.click(1);
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void ironfullscreen(final int i) {
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        progressBar = progressDialog2;
        progressDialog2.setCancelable(false);
        progressBar.setMessage("Ads Loading ...");
        progressBar.setProgressStyle(0);
        progressBar.show();

        mukesh_four_kal.this.progressBar.dismiss();
        mukesh_four_kal.this.click(i);
    }

    public void click(int i) {
        if (i == 1) {
            Intent intent2 = new Intent(this.activity, mukesh_four_ke.class);
            this.intent = intent2;
            startActivity(intent2);
//            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //back--ads--not--found
    }
}
