package com.fastcash.speedloancoach.quickloan.mukesh_pkg_seven;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eight.mukesh_four_bappa;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_ke;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_twelve.mukesh_four_kaa;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_twelve.mukesh_four_paiyaa;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_one.mukesh_four_name;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_five.mukesh_four_shree;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_thirteen.mukesh_four_teri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressLint("WrongConstant")

public class mukesh_four_kya extends AppCompatActivity {
    private static final String TAG = "ActInstantLoanTypes";
    public static ArrayList<mukesh_four_paiyaa> resultData;

    public int f46i = 0;
    FrameLayout frameLayout;
    RecyclerView loan_list;
    LinearLayout id_ll_dataNotFound;
    LinearLayout lottie_anim;
    ImageView imageView;
    ProgressDialog progressBar;
    View.OnClickListener onClickListener = new View.OnClickListener() {

        public void onClick(View view) {
            mukesh_four_shree.gclick++;
            if (mukesh_four_shree.gclick % mukesh_four_shree.click == 0) {
                mukesh_four_kya.this.ironfullscreen(1);
                int intValue = ((Integer) view.getTag()).intValue();
                Intent intent = new Intent(mukesh_four_kya.this.getApplicationContext(), mukesh_four_hi.class);
                intent.putExtra(mukesh_four_hi.Data, mukesh_four_kya.resultData.get(intValue));
                mukesh_four_kya.this.startActivity(intent);
                return;
            }
            int intValue2 = ((Integer) view.getTag()).intValue();
            Intent intent2 = new Intent(mukesh_four_kya.this.getApplicationContext(), mukesh_four_hi.class);
            intent2.putExtra(mukesh_four_hi.Data, mukesh_four_kya.resultData.get(intValue2));
            mukesh_four_kya.this.startActivity(intent2);
        }
    };
    ProgressDialog progressDialog;

    private boolean isOnline() {
        @SuppressLint("WrongConstant") NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_k);


        
        Inter_Ads_Manager.getInstance().displayInterstitial(this, new Inter_Ads_Manager.MyCallback() {
            @Override
            public void callbackCall() {
            }
        });
        Inter_Ads_Manager.getInstance().adaptivebanner(this, findViewById(R.id.adsContainer));


        //       progressDialog = new ProgressDialog(this);
//        if (isOnline()) {
//            progressDialog.setTitle("Loading Data");
//            progressDialog.setMessage("Please Wait a second");
//            progressDialog.hide();
//            new Handler().postDelayed(new Runnable() {
//                public void run() {
//                    mukesh_four_kya.this.progressDialog.isShowing();
//                    mukesh_four_kya.this.progressDialog.dismiss();
//                }
//            }, 3000);
//        }
        loan_list = (RecyclerView) findViewById(R.id.loan_list);
        id_ll_dataNotFound = findViewById(R.id.id_llNotFound);
        lottie_anim = findViewById(R.id.lottie_anim);
//        MS_CommonClass.toolbar(this, "Speed Loan Coach", false);
//        if (mukesh_four_bappa.isNetworkConnected(getApplicationContext())) {
//            getList();
//        }

    }

    public void setData() {

        loan_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        loan_list.setAdapter(new mukesh_four_name(getApplicationContext(), resultData, this.onClickListener));
        if (resultData.size() == 0) {
            loan_list.setVisibility(View.VISIBLE);
            id_ll_dataNotFound.setVisibility(View.GONE);
        } else {
            loan_list.setVisibility(View.GONE);
            id_ll_dataNotFound.setVisibility(View.GONE);
            lottie_anim.setVisibility(View.VISIBLE);
        }
    }

    public void getList() {
        mukesh_four_bappa.progressDialogShow(this);
        mukesh_four_ke.getInstance().addToRequestQueue(new StringRequest(0, "http://androidsolution.xyz/folder/aadharloan/listapp.json", new Response.Listener<String>() {

            public void onResponse(String str) {
                try {
                    mukesh_four_kya.resultData = (ArrayList) mukesh_four_kaa.parseJSON(str).getResultData();

                    mukesh_four_kya.this.setData();
                } catch (Exception unused) {
                }
                mukesh_four_bappa.progressDialogDismiss();
            }
        }, new Response.ErrorListener() {

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                mukesh_four_bappa.progressDialogDismiss();
            }
        }) {

            @Override // com.android.volley.Request
            public Map<String, String> getParams() {
                HashMap hashMap = new HashMap();
                return checkParams(hashMap);
            }

            private Map<String, String> checkParams(Map<String, String> map) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getValue() == null) {
                        map.put(entry.getKey(), "");
                    }
                }
                return map;
            }
        }, "FORGOT PASSWORD");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
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

        mukesh_four_kya.this.progressBar.dismiss();
    }

    public void click(int i) {
        if (i != 1 && i == 2) {
            startActivity(new Intent(this, mukesh_four_teri.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //back--ads--not--found
    }
}
