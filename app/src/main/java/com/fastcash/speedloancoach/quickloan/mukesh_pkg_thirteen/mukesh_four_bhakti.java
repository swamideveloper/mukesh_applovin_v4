package com.fastcash.speedloancoach.quickloan.mukesh_pkg_thirteen;

import android.annotation.SuppressLint;
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

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eight.mukesh_four_ghima;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_three.mukesh_four_kal;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_five.mukesh_four_shree;


@SuppressLint("WrongConstant")

public class mukesh_four_bhakti extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ActLoanTypes";


    public int f46i = 0;
    TextView tvTitle;
    ImageView ivBack;
    ProgressDialog progressBar;
    ProgressDialog progressDialog;
    private ImageView imgAutoLoan;
    private ImageView imgBusinessLoan;
    private ImageView imgHomeLoan;
    private ImageView imgMortgages;
    private ImageView imgPaydayLoan;
    private ImageView imgPersonalLoan;
    private ImageView imgSmallBusiness;
    private ImageView imgStudentLoan;

    private boolean isOnline() {
        @SuppressLint("MissingPermission") NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_g);


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
                    mukesh_four_bhakti.this.progressDialog.isShowing();
                    mukesh_four_bhakti.this.progressDialog.dismiss();
                }
            }, 3000);
        }
        imgPersonalLoan = (ImageView) findViewById(R.id.imgPersonalLoan);
        imgAutoLoan = (ImageView) findViewById(R.id.imgAutoLoan);
        imgHomeLoan = (ImageView) findViewById(R.id.imgHomeLoan);
        imgBusinessLoan = (ImageView) findViewById(R.id.imgBusinessLoan);
        imgStudentLoan = (ImageView) findViewById(R.id.imgStudentLoan);
        imgMortgages = (ImageView) findViewById(R.id.imgMortgages);
        imgPaydayLoan = (ImageView) findViewById(R.id.imgPaydayLoan);
        imgSmallBusiness = (ImageView) findViewById(R.id.imgSmallBusiness);
        ivBack = findViewById(R.id.id_ivBack);
        tvTitle = findViewById(R.id.id_tvTitle);

        ivBack.setOnClickListener(v -> onBackPressed());
        tvTitle.setText(R.string.loan_type);


        imgPersonalLoan.setOnClickListener(this);
        imgAutoLoan.setOnClickListener(this);
        imgHomeLoan.setOnClickListener(this);
        imgBusinessLoan.setOnClickListener(this);
        imgStudentLoan.setOnClickListener(this);
        imgMortgages.setOnClickListener(this);
        imgPaydayLoan.setOnClickListener(this);
        imgSmallBusiness.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgAutoLoan:
                mukesh_four_shree.gclick++;
                if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                    mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.AUTO_LOAN;
                    ironfullscreen(2);
                    return;
                }
                mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.AUTO_LOAN;
                click(2);
                return;
            case R.id.imgBusinessLoan:
                mukesh_four_shree.gclick++;
                if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                    mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.BUSINESS_LOAN;
                    ironfullscreen(4);
                    return;
                }
                mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.BUSINESS_LOAN;
                click(4);
                return;
            case R.id.imgHomeLoan:
                mukesh_four_shree.gclick++;
                if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                    mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.HOME_LOAN;
                    ironfullscreen(3);
                    return;
                }
                mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.HOME_LOAN;
                click(3);
                return;

            case R.id.imgMortgages:
                mukesh_four_shree.gclick++;
                if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                    mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.MORTGAGES;
                    ironfullscreen(6);
                    return;
                }
                mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.MORTGAGES;
                click(6);
                return;
            case R.id.imgPaydayLoan:
                mukesh_four_shree.gclick++;
                if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                    mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.PAYDAY_LOAN;
                    ironfullscreen(7);
                    return;
                }
                mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.PAYDAY_LOAN;
                click(7);
                return;
            case R.id.imgPersonalLoan:
                mukesh_four_shree.gclick++;
                if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                    mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.PERSONAL_LOAN;
                    ironfullscreen(1);
                    return;
                }
                mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.PERSONAL_LOAN;
                click(1);
                return;
            case R.id.imgSmallBusiness:
                mukesh_four_shree.gclick++;
                if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                    mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.SMALL_BUSINESS;
                    ironfullscreen(8);
                    return;
                }
                mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.SMALL_BUSINESS;
                click(8);
                return;
            case R.id.imgStudentLoan:
                mukesh_four_shree.gclick++;
                if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                    mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.STUDENT_LOAN;
                    ironfullscreen(5);
                    return;
                }
                mukesh_four_ke.SFLoanTPPP = mukesh_four_ghima.STUDENT_LOAN;
                click(5);
                return;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private void ironfullscreen(final int i) {
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        this.progressBar = progressDialog2;
        progressDialog2.setCancelable(false);
        this.progressBar.setMessage("Ads Loading ...");
        this.progressBar.setProgressStyle(0);
        this.progressBar.show();
        mukesh_four_bhakti.this.progressBar.dismiss();
        mukesh_four_bhakti.this.click(i);
    }

    public void click(int i) {
        if (i == 1) {
            startActivity(new Intent(this, mukesh_four_kal.class));
//            finish();
        } else if (i == 2) {
            startActivity(new Intent(this, mukesh_four_kal.class));
//            finish();
        } else if (i == 3) {
            startActivity(new Intent(this, mukesh_four_kal.class));
//            finish();
        } else if (i == 4) {
            startActivity(new Intent(this, mukesh_four_kal.class));
//            finish();
        } else if (i == 5) {
            startActivity(new Intent(this, mukesh_four_kal.class));
//            finish();
        } else if (i == 6) {
            startActivity(new Intent(this, mukesh_four_kal.class));
//            finish();
        } else if (i == 7) {
            startActivity(new Intent(this, mukesh_four_kal.class));
//            finish();
        } else if (i == 8) {
            startActivity(new Intent(this, mukesh_four_kal.class));
//            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //back--ads--not--found
    }
}
