package com.fastcash.speedloancoach.quickloan.mukesh_pkg_eleven;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.load.Key;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_five.mukesh_four_deva;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_thirteen.mukesh_four_ka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@SuppressLint("WrongConstant")

public class mukesh_four_choriya extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "IFSCbankListActivity";
    public static int f12913a = 1500;
    public static int f12914b = 1400;
    public static int f12915c = 1300;
    public static int f12916d = 1200;
    public int f46i = 0;
    public TextView txtAddress;
    public TextView txtBank;
    public TextView txtBranch;
    public TextView txtCity;
    public TextView txtIFSC;
    public TextView txtMICR;
    public TextView txtPhone;
    public TextView txtState;
    Activity activity;
    ImageView back6;
    boolean f12919f = false;
    Handler f12920g = new Handler();
    Runnable f12921h = new C30221(this);
    FrameLayout frameLayout;
    ProgressDialog progressBar;
    ProgressDialog progressDialog;
    private LinearLayout buttonLayout = null;
    private LinearLayout layoutDetails = null;
    private TextView lblBank;
    private RelativeLayout lblBranch;
    private RelativeLayout lblCity;
    private RelativeLayout lblState;
    private TextView txtBranchCode;
    private TextView txtCopyAll;
    private TextView txtCopyIFSC;
    private TextView txtShare;

    private boolean isOnline() {
        @SuppressLint("WrongConstant") NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void m16697f() throws IOException {
        lblBank = (TextView) findViewById(R.id.lblBank);
        lblState = findViewById(R.id.lblState);
        lblCity = findViewById(R.id.lblCity);
        lblBranch = findViewById(R.id.lblBranch);
        txtBank = (TextView) findViewById(R.id.txtBank);
        TextView textView = (TextView) findViewById(R.id.txtState);
        txtState = textView;
        textView.setVisibility(8);
        lblState.setVisibility(8);
        TextView textView2 = (TextView) findViewById(R.id.txtCity);
        txtCity = textView2;
        textView2.setVisibility(8);
        lblCity.setVisibility(8);
        TextView textView3 = (TextView) findViewById(R.id.txtBranch);
        txtBranch = textView3;
        textView3.setVisibility(8);
        lblBranch.setVisibility(8);
        txtIFSC = (TextView) findViewById(R.id.txtIFSC);
        txtMICR = (TextView) findViewById(R.id.txtMICR);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtBranchCode = (TextView) findViewById(R.id.txtBranchCode);
        txtCopyIFSC = (TextView) findViewById(R.id.txtCopyIFSC);
        txtCopyAll = (TextView) findViewById(R.id.txtCopyAll);
        txtShare = (TextView) findViewById(R.id.txtShare);
        txtCopyIFSC.setOnClickListener(new C30232(this));
        txtCopyAll.setOnClickListener(new C30243(this));
//        txtShare.setOnClickListener(new C30254(this));
        txtShare.setOnClickListener(new mukesh_four_deva() {
            @Override
            public void performClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", "BANK NAME: " + txtBank.getText().toString() + "\nState: " + txtState.getText().toString() + "\nCity: " + txtCity.getText().toString() + "\nBranch: " + txtBranch.getText().toString() + "\nIFSC: " + txtIFSC.getText().toString() + "\nMICR Code: " + txtMICR.getText().toString() + "\nAddress: " + txtAddress.getText().toString() + "\nPhone No: " + txtPhone.getText().toString() + "\nBranch Code: " + txtBranch.getText().toString());
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Send to..."));
            }
        });

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutDetails);
        layoutDetails = linearLayout;
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.buttonLayout);
        buttonLayout = linearLayout2;
        linearLayout2.setVisibility(8);
        txtBank.setOnClickListener(this);
        txtState.setOnClickListener(this);
        txtCity.setOnClickListener(this);
        txtBranch.setOnClickListener(this);
        int i = 0;
        String[] strArr = new String[0];
        try {
            strArr = getResources().getAssets().list("IFSC_Code");
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("IFSC_Code/" + strArr[0]), Key.STRING_CHARSET_NAME));
        List asList = Arrays.asList(bufferedReader.readLine().split("\\*"));

        try {
            bufferedReader.close();
        } catch (IOException unused) {
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(getResources().getAssets().open("IFSC_Code/" + strArr[0]), Key.STRING_CHARSET_NAME));
        bufferedReader2.readLine();
        String[] split = bufferedReader2.readLine().split("\\*\\*");
        List list = null;
        for (int i3 = 0; i3 < split.length; i3++) {
            if (split[i3].contains((CharSequence) asList.get(0))) {
                list = Arrays.asList(split[i3].split("->")[1].split("\\*"));
            }
        }

        BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(getResources().getAssets().open("IFSC_Code/" + strArr[0]), Key.STRING_CHARSET_NAME));
        bufferedReader3.readLine();
        bufferedReader3.readLine();
        String[] split2 = bufferedReader3.readLine().split("\\*\\*");
        int i5 = 0;
        List list2 = null;
        while (i5 < split2.length) {
            if (split2[i5].contains(((String) asList.get(i)) + "->" + ((String) list.get(0)))) {
                list2 = Arrays.asList(split2[i5].split("->")[2].split("\\*"));
            }
            i5++;
            i = 0;
        }

        BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(getResources().getAssets().open("IFSC_Code/" + strArr[0]), Key.STRING_CHARSET_NAME));
        bufferedReader4.readLine();
        bufferedReader4.readLine();
        bufferedReader4.readLine();
        String[] split3 = bufferedReader4.readLine().split("\\*\\*");

    }

    private void m16699g() {
        try {
            f12919f = true;
            f12920g.postDelayed(this.f12921h, 4000);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("IFSC_Code/" + this.txtBank.getText().toString() + ".txt"), Key.STRING_CHARSET_NAME));
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            String[] split = bufferedReader.readLine().split("\\*\\*");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(this.txtState.getText().toString() + "->" + this.txtCity.getText().toString() + "->" + this.txtBranch.getText().toString())) {
                    String[] split2 = split[i].split("->")[3].split("\\*");
                    txtIFSC.setText(split2[2]);
                    txtMICR.setText(split2[3]);
                    txtAddress.setText(split2[0]);
                    txtPhone.setText(split2[1]);
                    txtBranchCode.setText(split2[2].substring(split2[2].length() - 6, split2[2].length()));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        try {
            if (i == f12913a && i2 == -1) {
                txtBank.setText(intent.getStringExtra("BANK"));
                lblState.setVisibility(0);
                txtState.setVisibility(0);
                txtState.setText("Select State");
                lblCity.setVisibility(8);
                txtCity.setVisibility(8);
                txtCity.setText("Select City");
                lblBranch.setVisibility(8);
                txtBranch.setVisibility(8);
                txtBranch.setText("Select Branch");
                layoutDetails.setVisibility(8);
                buttonLayout.setVisibility(8);
            } else if (i == f12916d && i2 == -1) {
                txtState.setText(intent.getStringExtra("STATE"));
                lblCity.setVisibility(0);
                txtCity.setVisibility(0);
                txtCity.setText("Select City");
                lblBranch.setVisibility(8);
                txtBranch.setVisibility(8);
                txtBranch.setText("Select Branch");
                layoutDetails.setVisibility(8);
                buttonLayout.setVisibility(8);
            } else if (i == f12915c && i2 == -1) {
                txtCity.setText(intent.getStringExtra("CITY"));
                txtBranch.setVisibility(0);
                lblBranch.setVisibility(0);
                txtBranch.setText("Select Branch");
                layoutDetails.setVisibility(8);
                buttonLayout.setVisibility(8);
            } else if (i == f12914b && i2 == -1) {
                txtBranch.setText(intent.getStringExtra("BRANCH"));
                layoutDetails.setVisibility(0);
                buttonLayout.setVisibility(0);
                m16699g();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, mukesh_four_jaydev.class);
        switch (view.getId()) {
            case R.id.txtBank:
                intent.putExtra("POSITION", 1);
                startActivityForResult(intent, f12913a);
                return;
            case R.id.txtBranch:
                intent.putExtra("POSITION", 4);
                intent.putExtra("BANK_NAME", this.txtBank.getText().toString());
                intent.putExtra("STATE_NAME", this.txtState.getText().toString());
                intent.putExtra("CITY_NAME", this.txtCity.getText().toString());
                startActivityForResult(intent, f12914b);
                return;
            case R.id.txtCity:
                intent.putExtra("POSITION", 3);
                intent.putExtra("BANK_NAME", this.txtBank.getText().toString());
                intent.putExtra("STATE_NAME", this.txtState.getText().toString());
                startActivityForResult(intent, f12915c);
                return;
            case R.id.txtState:
                intent.putExtra("POSITION", 2);
                intent.putExtra("BANK_NAME", this.txtBank.getText().toString());
                startActivityForResult(intent, f12916d);
                return;
            default:
                return;
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_n);

        activity = mukesh_four_choriya.this;

        
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
                    mukesh_four_choriya.this.progressDialog.isShowing();
                    mukesh_four_choriya.this.progressDialog.dismiss();
                }
            }, 3000);
        }
        ImageView imageView = (ImageView) findViewById(R.id.back6);
        this.back6 = imageView;
        imageView.setOnClickListener(new C30265(this));
        try {
            m16697f();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        f12920g.postDelayed(this.f12921h, 4000);
    }

    public void ironfullscreen(final int i) {
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        progressBar = progressDialog2;
        progressDialog2.setCancelable(false);
        progressBar.setMessage("Ads Loading ...");
        progressBar.setProgressStyle(0);
        progressBar.show();

        mukesh_four_choriya.this.progressBar.dismiss();
        mukesh_four_choriya.this.click(i);
    }

    public void click(int i) {
        if (i == 1) {
            startActivity(new Intent(this, mukesh_four_ka.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //back--ads--not--found
    }

    class C30221 implements Runnable {
        final mukesh_four_choriya f12907a;

        C30221(mukesh_four_choriya iFSCbankListActivityVB) {
            this.f12907a = iFSCbankListActivityVB;
        }

        public void run() {
            boolean z = this.f12907a.f12919f;
        }
    }

    public class C30232 implements View.OnClickListener {
        final mukesh_four_choriya f12908a;

        C30232(mukesh_four_choriya iFSCbankListActivityVB) {
            this.f12908a = iFSCbankListActivityVB;
        }

        @SuppressLint("WrongConstant")
        public void onClick(View view) {
            ((ClipboardManager) this.f12908a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("IFSC", this.f12908a.txtIFSC.getText().toString()));
            Toast.makeText(this.f12908a, "Copied to clipboard", 0).show();
        }
    }

    public class C30243 implements View.OnClickListener {
        final mukesh_four_choriya f12909a;

        C30243(mukesh_four_choriya iFSCbankListActivityVB) {
            this.f12909a = iFSCbankListActivityVB;
        }

        @SuppressLint("WrongConstant")
        public void onClick(View view) {
            ((ClipboardManager) this.f12909a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("ALL", "BANK NAME: " + this.f12909a.txtBank.getText().toString() + "\nState: " + this.f12909a.txtState.getText().toString() + "\nCity: " + this.f12909a.txtCity.getText().toString() + "\nBranch: " + this.f12909a.txtBranch.getText().toString() + "\nIFSC: " + this.f12909a.txtIFSC.getText().toString() + "\nMICR Code: " + this.f12909a.txtMICR.getText().toString() + "\nAddress: " + this.f12909a.txtAddress.getText().toString() + "\nPhone No: " + this.f12909a.txtPhone.getText().toString() + "\nBranch Code: " + this.f12909a.txtBranch.getText().toString()));
            Toast.makeText(this.f12909a, "All data Copied to clipboard", 0).show();
        }
    }

    public class C30254 implements View.OnClickListener {
        final mukesh_four_choriya f12910a;

        C30254(mukesh_four_choriya iFSCbankListActivityVB) {
            this.f12910a = iFSCbankListActivityVB;
        }

        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", "BANK NAME: " + this.f12910a.txtBank.getText().toString() + "\nState: " + this.f12910a.txtState.getText().toString() + "\nCity: " + this.f12910a.txtCity.getText().toString() + "\nBranch: " + this.f12910a.txtBranch.getText().toString() + "\nIFSC: " + this.f12910a.txtIFSC.getText().toString() + "\nMICR Code: " + this.f12910a.txtMICR.getText().toString() + "\nAddress: " + this.f12910a.txtAddress.getText().toString() + "\nPhone No: " + this.f12910a.txtPhone.getText().toString() + "\nBranch Code: " + this.f12910a.txtBranch.getText().toString());
            intent.setType("text/plain");
            this.f12910a.startActivity(Intent.createChooser(intent, "Send to..."));
        }
    }

    class C30265 implements View.OnClickListener {
        final mukesh_four_choriya f12911a;

        C30265(mukesh_four_choriya iFSCbankListActivityVB) {
            this.f12911a = iFSCbankListActivityVB;
        }

        public void onClick(View view) {
            this.f12911a.onBackPressed();
        }
    }
}
