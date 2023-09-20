package com.fastcash.speedloancoach.quickloan.mukesh_pkg_thirteen;

import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mCountry;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mExitDialoge;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mLanguage;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mPermission;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mPrivacy;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mStart;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mThankYou;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eight.mukesh_four_ganpati;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eight.mukesh_four_bappa;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_two.mukesh_four_yaja;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_two.mukesh_four_mahe;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_two.mukesh_four_sungndhim;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_two.mukesh_four_bardhanam;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_two.mukesh_four_bhav;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_two.mukesh_four_rupe;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_four.mukesh_four_jala;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_four.mukesh_four_jalti;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_five.mukesh_four_shree;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eleven.mukesh_four_ladu;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eleven.mukesh_four_choriya;


@SuppressLint("WrongConstant")

public class mukesh_four_ka extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ActMainLayout";
    public Activity activity;
    public int f46i = 0;
    public Intent intent;

    RelativeLayout cvcashcounter;
    boolean isBack = false;
    ProgressDialog progressBar;
    ProgressDialog progressDialog;
    //back------------------------------------------------------------------------------------------
    boolean doubleBackToExitPressedOnce = false;
    private LinearLayout cvBankBalance;
    private RelativeLayout cvInstantCash;
    private LinearLayout cvLoanStatus;
    private RelativeLayout cvLoanTypes;
    private ImageView cvLuckySpinner;
    private ImageView cvVideoStatus;
    private LinearLayout ifsc_code;
    private TextView tvAccountName;
    private TextView tvName;
    private TextView tvNumber;

    private boolean isOnline() {
        @SuppressLint({"MissingPermission", "WrongConstant"}) NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_h);

        activity = this;


        if (getIntent().getBooleanExtra("app_inter", false)) {
            
            Inter_Ads_Manager.getInstance().displayInterstitial(this, new Inter_Ads_Manager.MyCallback() {
                @Override
                public void callbackCall() {
                }
            });
        }
        Inter_Ads_Manager.getInstance().refreshAd(this, findViewById(R.id.adsContainer));


        progressDialog = new ProgressDialog(this);
        if (isOnline()) {
            progressDialog.setTitle("Loading Data");
            progressDialog.setMessage("Please Wait a second");
            progressDialog.hide();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    mukesh_four_ka.this.progressDialog.isShowing();
                    mukesh_four_ka.this.progressDialog.dismiss();
                }
            }, 3000);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvAccountName = (TextView) findViewById(R.id.tvAccountName);
        ifsc_code = (LinearLayout) findViewById(R.id.ifsc_code);
        cvBankBalance = (LinearLayout) findViewById(R.id.cvBankBalance);
        cvLoanStatus = (LinearLayout) findViewById(R.id.cvLoanStatus);
        cvLoanTypes = (RelativeLayout) findViewById(R.id.cvLoanTypes);
        cvInstantCash = (RelativeLayout) findViewById(R.id.cvInstantCash);
        cvcashcounter = (RelativeLayout) findViewById(R.id.cvcashcounter);
        TextView textView = this.tvAccountName;
        textView.setText("Hello " + mukesh_four_ganpati.getName() + "!");
        cvBankBalance.setOnClickListener(this);
        cvLoanStatus.setOnClickListener(this);
        cvLoanTypes.setOnClickListener(this);
        cvInstantCash.setOnClickListener(this);
        cvcashcounter.setOnClickListener(this);
        ifsc_code.setOnClickListener(this);
        findViewById(R.id.cvCalc).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (mukesh_four_bappa.isNetworkConnected(this.activity)) {
            switch (view.getId()) {
                case R.id.cvBankBalance:
                    mukesh_four_shree.gclick++;
                    if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                        ironfullscreen(6);
                        return;
                    } else {
                        click(6);
                        return;
                    }
                case R.id.cvCalc:
                    mukesh_four_shree.gclick++;
                    if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                        ironfullscreen(3);
                        return;
                    } else {
                        click(3);
                        return;
                    }
                case R.id.cvInstantCash:
                    mukesh_four_shree.gclick++;
                    if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                        ironfullscreen(5);
                        return;
                    } else {
                        click(5);
                        return;
                    }
                case R.id.cvLoanStatus:
                    mukesh_four_shree.gclick++;
                    if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                        ironfullscreen(7);
                        return;
                    } else {
                        click(7);
                        return;
                    }
                case R.id.cvLoanTypes:
                    mukesh_four_shree.gclick++;
                    if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                        ironfullscreen(1);
                        return;
                    } else {
                        click(1);
                        return;
                    }
                case R.id.cvcashcounter:
                    mukesh_four_shree.gclick++;
                    if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                        ironfullscreen(15);
                        return;
                    } else {
                        click(15);
                        return;
                    }
                case R.id.ifsc_code:
                    mukesh_four_shree.gclick++;
                    if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                        ironfullscreen(8);
                        return;
                    } else {
                        click(8);
                        return;
                    }
                default:
                    return;
            }
        } else {
            Toast.makeText(this.activity, getResources().getString(R.string.strNoInternet), 0).show();
        }
    }

    private void ironfullscreen(final int i) {
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        progressBar = progressDialog2;
        progressDialog2.setCancelable(false);
        progressBar.setMessage("Ads Loading ...");
        progressBar.setProgressStyle(0);
        progressBar.show();
        mukesh_four_ka.this.progressBar.dismiss();
        mukesh_four_ka.this.click(i);
    }

    public void click(int i) {
        if (i == 1) {
            Intent intent2 = new Intent(this.activity, mukesh_four_bhakti.class);
            this.intent = intent2;
            startActivity(intent2);
        } else if (i == 3) {
            Intent intent3 = new Intent(this.activity, mukesh_four_chale.class);
            this.intent = intent3;
            startActivity(intent3);
        } else if (i == 5) {
            Intent intent4 = new Intent(this.activity, mukesh_four_teri.class);
            this.intent = intent4;
            startActivity(intent4);
        } else if (i == 6) {
            Intent intent5 = new Intent(this.activity, mukesh_four_ladu.class);
            this.intent = intent5;
            startActivity(intent5);
        } else if (i == 7) {
            Intent intent6 = new Intent(this.activity, mukesh_four_chaya.class);
            this.intent = intent6;
            startActivity(intent6);
        } else if (i == 8) {
            Intent intent7 = new Intent(this.activity, mukesh_four_choriya.class);
            this.intent = intent7;
            startActivity(intent7);
        } else if (i == 10) {
            Intent intent8 = new Intent(this.activity, mukesh_four_chaya.class);
            this.intent = intent8;
            startActivity(intent8);
        } else if (i == 12) {
            Intent intent9 = new Intent(this.activity, mukesh_four_jala.class);
            this.intent = intent9;
            intent9.putExtra("title", "Terms & Condition");
            this.intent.putExtra("link", mukesh_four_shree.privacy);
            startActivity(this.intent);
        } else if (i == 15) {
            startActivity(new Intent(this, mukesh_four_jalti.class));
        }
    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

        if (mStart.equalsIgnoreCase("on")) {
            startActivity(new Intent(context, mukesh_four_bardhanam.class).putExtra("app_inter", true));
            finish();
        } else if (mPermission.equalsIgnoreCase("on")) {
            startActivity(new Intent(context, mukesh_four_rupe.class).putExtra("app_inter", true));
            finish();
        } else if (mLanguage.equalsIgnoreCase("on")) {
            startActivity(new Intent(context, mukesh_four_bhav.class).putExtra("app_inter", true));
            finish();
        } else if (mPrivacy.equalsIgnoreCase("on")) {
            startActivity(new Intent(context, mukesh_four_sungndhim.class).putExtra("app_inter", true));
            finish();
        } else if (mCountry.equalsIgnoreCase("on")) {
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
