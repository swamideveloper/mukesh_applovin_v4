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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_twelve.mukesh_four_chadde;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_one.mukesh_four_hoo;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_five.mukesh_four_shree;

import java.util.ArrayList;

@SuppressLint("WrongConstant")

public class mukesh_four_chaya extends AppCompatActivity {
    private static final String TAG = "ActLoanStatus";

    public Activity activity;
    public int f46i = 0;
    public Intent intent;
    FrameLayout frame11;
    FrameLayout frameLayout;
    TextView tvTitle;
    ImageView ivBack;
    ProgressDialog progressBar;
    ProgressDialog progressDialog;
    private LinearLayout btnApply;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<mukesh_four_chadde> list = new ArrayList<>();
    private LinearLayout llNoLoan;
    private mukesh_four_hoo VBLoanStatusAdapter;
    private RecyclerView recyclerView;

    private boolean isOnline() {
        @SuppressLint({"MissingPermission", "WrongConstant"}) NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_f);


        
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
                    mukesh_four_chaya.this.progressDialog.isShowing();
                    mukesh_four_chaya.this.progressDialog.dismiss();
                }
            }, 3000);
        }
        this.activity = this;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        llNoLoan = (LinearLayout) findViewById(R.id.llNoLoan);
        btnApply = (LinearLayout) findViewById(R.id.btnApply);
        tvTitle = findViewById(R.id.id_tvTitle);
        ivBack = findViewById(R.id.id_ivBack);
        ivBack.setOnClickListener(v -> onBackPressed());
        tvTitle.setText(R.string.loan_status);

        ArrayList<mukesh_four_chadde> arrayList = (ArrayList) mukesh_four_ke.SFLoanDB.getAllLoan();
        this.list = arrayList;
        if (arrayList.size() == 0) {
            this.llNoLoan.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.activity);
            linearLayoutManager = linearLayoutManager2;
            recyclerView.setLayoutManager(linearLayoutManager2);
            mukesh_four_hoo VBLoanStatusAdapter2 = new mukesh_four_hoo(this.activity, this.list);
            VBLoanStatusAdapter = VBLoanStatusAdapter2;
            recyclerView.setAdapter(VBLoanStatusAdapter2);
        }
        this.btnApply.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                mukesh_four_shree.gclick++;
                if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                    mukesh_four_chaya.this.ironfullscreen(1);
                } else {
                    mukesh_four_chaya.this.click(1);
                }
            }
        });
    }


    public void ironfullscreen(final int i) {
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        this.progressBar = progressDialog2;
        progressDialog2.setCancelable(false);
        this.progressBar.setMessage("Ads Loading ...");
        this.progressBar.setProgressStyle(0);
        this.progressBar.show();
        mukesh_four_chaya.this.progressBar.dismiss();
        mukesh_four_chaya.this.click(i);
    }

    public void click(int i) {
        if (i == 1) {
            Intent intent2 = new Intent(this.activity, mukesh_four_bhakti.class);
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
