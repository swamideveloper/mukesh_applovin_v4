package com.fastcash.speedloancoach.quickloan.mukesh_pkg_eleven;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;

@SuppressLint("WrongConstant")

public class mukesh_four_dev extends AppCompatActivity {
    private static final String TAG = "ActBankInformation";
    public int f46i = 0;
    ProgressDialog progressDialog;
    ImageView imgBack;
    String b_name, b_number;
    Integer b_img;
    private LinearLayout cvDial;
    private ImageView imgIcon;
    private TextView tvName;
    private TextView tvNumber;

    private boolean isOnline() {
        @SuppressLint({"MissingPermission", "WrongConstant"}) NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_silver);


        
        Inter_Ads_Manager.getInstance().displayInterstitial(this, new Inter_Ads_Manager.MyCallback() {
            @Override
            public void callbackCall() {
            }
        });
        Inter_Ads_Manager.getInstance().refreshAd(this, findViewById(R.id.adsContainer));

        Intent intent = getIntent();
        b_img = intent.getIntExtra("image", 0);
        b_name = intent.getStringExtra("NAME");
        b_number = intent.getStringExtra("number");

        progressDialog = new ProgressDialog(this);
        if (isOnline()) {
            progressDialog.setTitle("Loading Data");
            progressDialog.setMessage("Please Wait a second");
            progressDialog.hide();
            new Handler().postDelayed(new Runnable() {

                public void run() {
                    mukesh_four_dev.this.progressDialog.isShowing();
                    mukesh_four_dev.this.progressDialog.dismiss();
                }
            }, 3000);
        }
        imgIcon = (ImageView) findViewById(R.id.imgIcon);
        cvDial = (LinearLayout) findViewById(R.id.cvDial);
        tvName = (TextView) findViewById(R.id.tvName);
        tvNumber = (TextView) findViewById(R.id.tvNumber);
        imgBack = findViewById(R.id.id_ivBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        imgIcon.setImageResource(b_img);
        tvName.setText(b_name);
        tvNumber.setText(b_number);

        cvDial.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                ((ClipboardManager) mukesh_four_dev.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Bank Balance Check Number :", mukesh_four_dev.this.tvNumber.getText().toString()));
                Toast.makeText(mukesh_four_dev.this.getApplicationContext(), "Number Copied to clipboard... Please dial number in your dial pad", 0).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //back--ads--not--found
    }
}
