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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_seven.mukesh_four_kya;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eight.mukesh_four_ghima;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eight.mukesh_four_ganpati;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_one.mukesh_four_tera;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_one.mukesh_four_parvah;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_five.mukesh_four_shree;

import java.util.ArrayList;

@SuppressLint("WrongConstant")

public class mukesh_four_ke extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ActSelectAmount";
    public String emiTerms = "0";
    public int f46i = 0;
    public ArrayList<String> listAmount = new ArrayList<>();
    public ArrayList<String> listTerms = new ArrayList<>();
    public String loanAmount = "0";
    FrameLayout frame11;
    FrameLayout frameLayout;
    TextView tvTitle;
    ImageView ivBack;
    ProgressDialog progressBar;
    ProgressDialog progressDialog;
    private Activity activity;
    private mukesh_four_parvah VBAmountAdapter;
    private LinearLayout btnNext;
    private String emiAmount = "0";
    private GridLayoutManager gridLayoutManager;
    private Intent intent;
    private RecyclerView rvAmount;
    private RecyclerView rvTerms;
    private mukesh_four_tera VBTermsAdapter;
    private TextView tvEmi;

    private boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_i);


        
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
                /* class com.twadd.instant.instntlngudese.LoanApply.ActSelectAmount.AnonymousClass1 */

                public void run() {
                    mukesh_four_ke.this.progressDialog.isShowing();
                    mukesh_four_ke.this.progressDialog.dismiss();
                }
            }, 3000);
        }
        activity = this;
        rvAmount = (RecyclerView) findViewById(R.id.rvAmount);
        rvTerms = (RecyclerView) findViewById(R.id.rvTerms);
        tvEmi = (TextView) findViewById(R.id.tvEmi);
        LinearLayout button = (LinearLayout) findViewById(R.id.btnNext);
        btnNext = button;
        button.setOnClickListener(this);
        tvTitle = findViewById(R.id.id_tvTitle);
        ivBack = findViewById(R.id.id_ivBack);
        ivBack.setOnClickListener(v -> onBackPressed());
        tvTitle.setText(com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP.getName());
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this.activity, 3);
        gridLayoutManager = gridLayoutManager2;
        rvAmount.setLayoutManager(gridLayoutManager2);
        addAmount();
        mukesh_four_parvah VBAmountAdapter2 = new mukesh_four_parvah(this.activity, this.listAmount, new mukesh_four_parvah.CustomItemClickListener() {

            @Override
            public void onItemClick(View view, int i) {
                mukesh_four_ke VBActSelectAmount = mukesh_four_ke.this;
                VBActSelectAmount.loanAmount = VBActSelectAmount.listAmount.get(i);
                mukesh_four_ke.this.calculateEmiAmount();
            }
        });
        VBAmountAdapter = VBAmountAdapter2;
        rvAmount.setAdapter(VBAmountAdapter2);
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this.activity, 3);
        gridLayoutManager = gridLayoutManager3;
        rvTerms.setLayoutManager(gridLayoutManager3);
        listTerms.add("3");
        listTerms.add("6");
        listTerms.add("12");
        listTerms.add("24");
        listTerms.add("36");
        listTerms.add("48");
        mukesh_four_tera VBTermsAdapter2 = new mukesh_four_tera(this.activity, this.listTerms, new mukesh_four_tera.CustomItemClickListener() {

            @Override
            public void onItemClick(View view, int i) {
                mukesh_four_ke VBActSelectAmount = mukesh_four_ke.this;
                VBActSelectAmount.emiTerms = VBActSelectAmount.listTerms.get(i);
                mukesh_four_ke.this.calculateEmiAmount();
            }
        });
        VBTermsAdapter = VBTermsAdapter2;
        rvTerms.setAdapter(VBTermsAdapter2);
        loanAmount = this.listAmount.get(0);
        emiTerms = this.listTerms.get(0);
        calculateEmiAmount();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnNext) {
            mukesh_four_shree.gclick++;
            if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                mukesh_four_ganpati.editorString("loanAmount", this.loanAmount);
                mukesh_four_ganpati.editorString("emiTerms", this.emiTerms);
                mukesh_four_ganpati.editorString("emiAmount", this.emiAmount);
                ironfullscreen(1);
                return;
            }
            mukesh_four_ganpati.editorString("loanAmount", this.loanAmount);
            mukesh_four_ganpati.editorString("emiTerms", this.emiTerms);
            mukesh_four_ganpati.editorString("emiAmount", this.emiAmount);
            click(1);
        }
    }

    public void calculateEmiAmount() {
        double parseDouble = Double.parseDouble(this.loanAmount) / Double.parseDouble(this.emiTerms);
        TextView textView = this.tvEmi;
        textView.setText("Monthly EMI Amount is Rs." + String.format("%.2f", Double.valueOf(parseDouble)));
        this.emiAmount = String.format("%.2f", Double.valueOf(parseDouble));
    }

    public void addAmount() {
        if (com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.PERSONAL_LOAN) {
            listAmount.add("1000");
            listAmount.add("5000");
            listAmount.add("10000");
            listAmount.add("50000");
            listAmount.add("100000");
            listAmount.add("150000");
        } else if (com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.AUTO_LOAN) {
            listAmount.add("50000");
            listAmount.add("100000");
            listAmount.add("200000");
            listAmount.add("500000");
            listAmount.add("1000000");
            listAmount.add("1500000");
        } else if (com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.HOME_LOAN) {
            listAmount.add("500000");
            listAmount.add("1000000");
            listAmount.add("1500000");
            listAmount.add("2000000");
            listAmount.add("3000000");
            listAmount.add("5000000");
        } else if (com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.BUSINESS_LOAN) {
            listAmount.add("500000");
            listAmount.add("1000000");
            listAmount.add("1500000");
            listAmount.add("2000000");
            listAmount.add("3000000");
            listAmount.add("5000000");
        } else if (com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.STUDENT_LOAN) {
            listAmount.add("10000");
            listAmount.add("20000");
            listAmount.add("50000");
            listAmount.add("100000");
            listAmount.add("200000");
            listAmount.add("500000");
        } else if (com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.MORTGAGES) {
            listAmount.add("500000");
            listAmount.add("1000000");
            listAmount.add("1500000");
            listAmount.add("2000000");
            listAmount.add("3000000");
            listAmount.add("5000000");
        } else if (com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.PAYDAY_LOAN) {
            listAmount.add("1000");
            listAmount.add("5000");
            listAmount.add("10000");
            listAmount.add("50000");
            listAmount.add("100000");
            listAmount.add("150000");
        } else if (com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke.SFLoanTPPP == mukesh_four_ghima.SMALL_BUSINESS) {
            listAmount.add("50000");
            listAmount.add("100000");
            listAmount.add("150000");
            listAmount.add("200000");
            listAmount.add("350000");
            listAmount.add("500000");
        }
    }


    private void ironfullscreen(final int i) {
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        progressBar = progressDialog2;
        progressDialog2.setCancelable(false);
        progressBar.setMessage("Ads Loading ...");
        progressBar.setProgressStyle(0);
        progressBar.show();

        mukesh_four_ke.this.progressBar.dismiss();
        mukesh_four_ke.this.click(i);
    }

    public void click(int i) {
        if (i == 1) {
            Intent intent2 = new Intent(this.activity, mukesh_four_kya.class);
            intent = intent2;
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
