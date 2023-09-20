package com.fastcash.speedloancoach.quickloan.mukesh_pkg_seven;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eight.mukesh_four_bappa;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_twelve.mukesh_four_paiyaa;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_five.mukesh_four_shree;


@SuppressLint("WrongConstant")

public class mukesh_four_hi extends AppCompatActivity {
    private static final String TAG = "ActLoanDetils";
    public static String Data = "data";
    public int f46i = 0;
    TextView amount;
    mukesh_four_paiyaa SFLoanList;
    TextView app_name;
    TextView apply_loan;
    ImageView back2;
    FrameLayout frameLayout;
    TextView interest;
    int position;
    ProgressDialog progressBar;
    ProgressDialog progressDialog;
    TextView term;

    private boolean isOnline() {
        @SuppressLint("WrongConstant") NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_l);


        frameLayout = (FrameLayout) findViewById(R.id.fl_adplaceholder);

        banneriron();

        progressDialog = new ProgressDialog(this);
        if (isOnline()) {
            progressDialog.setTitle("Loading Data");
            progressDialog.setMessage("Please Wait a second");
            progressDialog.hide();
            new Handler().postDelayed(new Runnable() {

                public void run() {
                    mukesh_four_hi.this.progressDialog.isShowing();
                    mukesh_four_hi.this.progressDialog.dismiss();
                }
            }, 3000);
        }
        Intent intent = getIntent();
        if (intent != null) {
            SFLoanList = (mukesh_four_paiyaa) intent.getSerializableExtra(Data);
        }
        mukesh_four_bappa.toolbar(this, "Loan Details", false);
        app_name = (TextView) findViewById(R.id.app_name);
        amount = (TextView) findViewById(R.id.amount);
        interest = (TextView) findViewById(R.id.interest);
        term = (TextView) findViewById(R.id.term);
        apply_loan = (TextView) findViewById(R.id.apply_loan);
        app_name.setText(this.SFLoanList.getAppName());
        amount.setText(this.SFLoanList.getBorrowRange());
        interest.setText(this.SFLoanList.getInterest());
        term.setText(this.SFLoanList.getBorrowTerm());
        apply_loan.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                mukesh_four_shree.gclick++;
                if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                    mukesh_four_hi.this.ironfullscreen(1);
                } else {
                    mukesh_four_hi.this.click(1);
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void banneriron() {
        final FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.bannerContainer);
        frameLayout2.setVisibility(0);

        frameLayout2.removeAllViews();
        mukesh_four_hi.this.showgbanner();
    }

    public void showgbanner() {
        View findViewById = findViewById(R.id.banner_container);
        findViewById.setVisibility(0);
    }


    public void ironfullscreen(final int i) {
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        progressBar = progressDialog2;
        progressDialog2.setCancelable(false);
        progressBar.setMessage("Ads Loading ...");
        progressBar.setProgressStyle(0);
        progressBar.show();

        mukesh_four_hi.this.progressBar.dismiss();
        mukesh_four_hi.this.click(i);
    }

    public void click(int i) {
        if (i == 1) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + this.SFLoanList.getPackageNameStr())));
        } else if (i == 2) {
            startActivity(new Intent(this, mukesh_four_kya.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //back--ads--not--found
    }
}
