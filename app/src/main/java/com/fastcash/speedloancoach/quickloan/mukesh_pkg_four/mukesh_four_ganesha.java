package com.fastcash.speedloancoach.quickloan.mukesh_pkg_four;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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

public class mukesh_four_ganesha extends AppCompatActivity implements View.OnClickListener {
    TextView detailsloan;
    ProgressDialog progressBar;
    TextView tvTitle;
    ImageView ivBack;
    private ImageView imgAutoLoan;
    private ImageView imgBusinessLoan;
    private ImageView imgHomeLoan;
    private ImageView imgMortgages;
    private ImageView imgPaydayLoan;
    private ImageView imgPersonalLoan;
    private ImageView imgSmallBusiness;
    private ImageView imgStudentLoan;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.mukesh_four_d);


        
        Inter_Ads_Manager.getInstance().displayInterstitial(this, new Inter_Ads_Manager.MyCallback() {
            @Override
            public void callbackCall() {
            }
        });
        Inter_Ads_Manager.getInstance().refreshAd(this, findViewById(R.id.adsContainer));

        ivBack = findViewById(R.id.id_ivBack);
        tvTitle = findViewById(R.id.id_tvTitle);

        ivBack.setOnClickListener(v -> onBackPressed());
        tvTitle.setText(R.string.loan_information);

        detailsloan = findViewById(R.id.detailsloan);

        imgPersonalLoan = (ImageView) findViewById(R.id.imgPersonalLoan);
        imgAutoLoan = (ImageView) findViewById(R.id.imgAutoLoan);
        imgHomeLoan = (ImageView) findViewById(R.id.imgHomeLoan);
        imgBusinessLoan = (ImageView) findViewById(R.id.imgBusinessLoan);
        imgStudentLoan = (ImageView) findViewById(R.id.imgStudentLoan);
        imgMortgages = (ImageView) findViewById(R.id.imgMortgages);
        imgPaydayLoan = (ImageView) findViewById(R.id.imgPaydayLoan);
        imgSmallBusiness = (ImageView) findViewById(R.id.imgSmallBusiness);

        imgPersonalLoan.setOnClickListener(this);
        imgAutoLoan.setOnClickListener(this);
        imgHomeLoan.setOnClickListener(this);
        imgBusinessLoan.setOnClickListener(this);
        imgStudentLoan.setOnClickListener(this);
        imgMortgages.setOnClickListener(this);
        imgPaydayLoan.setOnClickListener(this);
        imgSmallBusiness.setOnClickListener(this);

        if (mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.HOME_LOAN) {
            detailsloan.setText(R.string.homeloandata);
        } else if (mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.AUTO_LOAN) {
            detailsloan.setText(R.string.autoloandata);
        } else if (mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.BUSINESS_LOAN) {
            detailsloan.setText(R.string.bussinessloandata);
        } else if (mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.MORTGAGES) {
            detailsloan.setText(R.string.moratagesdata);
        } else if (mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.PAYDAY_LOAN) {
            detailsloan.setText(R.string.paydayloandata);
        } else if (mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.PERSONAL_LOAN) {
            detailsloan.setText(R.string.personaldata);
        } else if (mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.SMALL_BUSINESS) {
            detailsloan.setText(R.string.smallbusinessdata);
        } else if (mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.STUDENT_LOAN) {
            detailsloan.setText(R.string.studentloandata);
        }
    }


    public void ironfullscreen(final int i) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressBar = progressDialog;
        progressDialog.setCancelable(false);
        progressBar.setMessage("Ads Loading ...");
        progressBar.setProgressStyle(0);
        progressBar.show();

        mukesh_four_ganesha.this.progressBar.dismiss();
        mukesh_four_ganesha.this.click(i);
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
    public void onBackPressed() {
        super.onBackPressed();
        //back--ads--not--found
    }
}
