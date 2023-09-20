package com.fastcash.speedloancoach.quickloan.mukesh_pkg_eleven;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_twelve.mukesh_four_rath;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_one.mukesh_four_dil;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint("WrongConstant")

public class mukesh_four_ladu extends AppCompatActivity {
    private static final String TAG = "ActCheckBankBalance";

    public Activity activity;
    public ArrayList<mukesh_four_rath> SFLoanBankDetails = new ArrayList<>();
    public int f46i = 0;
    public RecyclerView recyclerView;
    mukesh_four_dil VBBankListAdapter;
    ImageView id_ivBack;
    TextView id_tvTitle;
    TextView tv_nodata;
    ProgressDialog progressDialog;
    private EditText etSearch;

    private boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_c);


        
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
                    mukesh_four_ladu.this.progressDialog.isShowing();
                    mukesh_four_ladu.this.progressDialog.dismiss();
                }
            }, 3000);
        }
        activity = this;

        etSearch = (EditText) findViewById(R.id.etSearch);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        tv_nodata = findViewById(R.id.tv_nodata);
        id_ivBack = findViewById(R.id.id_ivBack);
        id_ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        id_tvTitle = findViewById(R.id.id_tvTitle);
        id_tvTitle.setText(R.string.bank_balance);

        getWindow().setSoftInputMode(2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        SFLoanBankDetails = new ArrayList<>();
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_allahabad_bank, "Allahabad\nBank", "Allahabad Bank", "+91 9224150150"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_andhra_bank, "Andhra\nBank", "Andhra Bank", "+91 9223011300"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_bank_of_india, "Bank Of\nIndia", "Bank Of India", "+91 9015135135"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_canara_bank, "Canara\nBank", "Canara Bank", "+91 9015483483"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_central_bank_of_india, "Central\nBank", "Central Bank Of India", "+91 9555244442"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_federal_bank, "Federal\nBank", "Federal Bank", "+91 8431900900"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_hdfc_bank, "HDFC\nBank", "HDFC Bank", "18002703333"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_icici_bank, "AXIS\nBank", "AXIS Bank", "18604195555"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_idbi_bank, "IDBI\nBank", "IDBI Bank", "18008431122"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_indian_bank, "Indian\nBank", "Indian Bank", "+91 9289592895"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_indusind_bank, "Maharashtra\nBank", "Maharashtra Bank", "18002334526"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_kotak_mahindra_bank, "Kotak\nBank", "Kotak Mahindra Bank", "18002740110"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_punjab_national_bank, "Punjab\nBank", "Punjab National Bank", "18001802223"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_rbl_bank, "SBI\nBank", "SBI Bank", "18001234"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_saraswat_bank, "Saraswat\nBank", "Saraswat Co-operative Bank", "9223040000"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_uco_bank, "UCO\nBank", "UCO Bank", "+91 9278792787"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_union_bank, "Union\nBank", "Union Bank Of India", "+91 9223008586"));
        SFLoanBankDetails.add(new mukesh_four_rath(R.drawable.ic_yes_bank, "Yes\nBank", "Yes Bank", "+91 9223920000"));
        mukesh_four_dil VBBankListAdapter2 = new mukesh_four_dil(this.activity, this.SFLoanBankDetails);
        VBBankListAdapter = VBBankListAdapter2;
        recyclerView.setAdapter(VBBankListAdapter2);
        etSearch.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @SuppressLint("NotifyDataSetChanged")
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                if (charSequence.length() == 0) {
                    tv_nodata.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                    VBBankListAdapter.notifyDataSetChanged();

                } else {
                    tv_nodata.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);

                }
                VBBankListAdapter.notifyDataSetChanged();
            }

            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
                if (VBBankListAdapter.getItemCount() == 0) {
                    tv_nodata.setVisibility(View.VISIBLE);
                } else {
                    tv_nodata.setVisibility(View.GONE);
                }
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void filter(String str) {
        ArrayList<mukesh_four_rath> arrayList = new ArrayList<>();
        Iterator<mukesh_four_rath> it = SFLoanBankDetails.iterator();
        while (it.hasNext()) {
            mukesh_four_rath next = it.next();
            if (next.getName().toLowerCase().startsWith(str.toLowerCase())) {
                arrayList.add(next);
            }
        }

        if (str.isEmpty()) {
            tv_nodata.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            VBBankListAdapter = new mukesh_four_dil(activity, SFLoanBankDetails);
            recyclerView.setAdapter(VBBankListAdapter);
            VBBankListAdapter.notifyDataSetChanged();
        } else {
            tv_nodata.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        VBBankListAdapter.filterList(arrayList);
        VBBankListAdapter.notifyDataSetChanged();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //back--ads--not--found
    }
}
