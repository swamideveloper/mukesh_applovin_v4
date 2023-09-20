package com.fastcash.speedloancoach.quickloan.mukesh_pkg_eleven;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.Key;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressLint("WrongConstant")

public class mukesh_four_jaydev extends AppCompatActivity {
    private static final String TAG = "IFSCListActivity";
    public List<String> f12901d = new ArrayList();
    public int f46i = 0;
    int f12898a = 0;
    ProgressDialog progressDialog;
    private String f12899b = "";
    private List<String> f12900c = new ArrayList();
    private C3021a f12902e;
    private RecyclerView f12904g;
    private SearchView f12905h = null;
    private String f12906i;

    public void click(int i) {
    }

    private boolean isOnline() {
        @SuppressLint("WrongConstant") NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void m16690f() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleList);
        f12904g = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        C3021a c3021a = new C3021a(this);
        f12902e = c3021a;
        f12904g.setAdapter(c3021a);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_u);


        
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
                /* class com.fastcash.speedloancoach.quickloanwadd.instant.instntlngudese.BankData.IFSCListActivity.AnonymousClass1 */

                public void run() {
                    mukesh_four_jaydev.this.progressDialog.isShowing();
                    mukesh_four_jaydev.this.progressDialog.dismiss();
                }
            }, 3000);
        }
        int i = 0;
        f12898a = getIntent().getIntExtra("POSITION", 0);
        f12901d.clear();
        f12900c.clear();
        int i2 = this.f12898a;
        if (i2 == 1) {
            try {
                String[] list = getResources().getAssets().list("IFSC_Code");
                while (i < list.length) {
                    String replace = list[i].replace(".txt", "");
                    this.f12901d.add(replace);
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i2 == 2) {
            String stringExtra = getIntent().getStringExtra("BANK_NAME");
            this.f12906i = stringExtra;
            try {
                AssetManager assets = getResources().getAssets();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assets.open("IFSC_Code/" + this.f12906i + ".txt"), Key.STRING_CHARSET_NAME));
                this.f12901d = new LinkedList(Arrays.asList(bufferedReader.readLine().split("\\*")));
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (i2 == 3) {
            f12906i = getIntent().getStringExtra("BANK_NAME");
            String stringExtra2 = getIntent().getStringExtra("STATE_NAME");
            try {
                AssetManager assets2 = getResources().getAssets();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(assets2.open("IFSC_Code/" + this.f12906i + ".txt"), Key.STRING_CHARSET_NAME));
                bufferedReader2.readLine();
                String[] split = bufferedReader2.readLine().split("\\*\\*");
                while (i < split.length) {
                    if (split[i].contains(stringExtra2)) {
                        this.f12901d = new LinkedList(Arrays.asList(split[i].split("->")[1].split("\\*")));
                    }
                    i++;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else if (i2 == 4) {
            this.f12906i = getIntent().getStringExtra("BANK_NAME");
            String stringExtra3 = getIntent().getStringExtra("STATE_NAME");
            String stringExtra4 = getIntent().getStringExtra("CITY_NAME");
            try {
                AssetManager assets3 = getResources().getAssets();
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(assets3.open("IFSC_Code/" + this.f12906i + ".txt"), Key.STRING_CHARSET_NAME));
                bufferedReader3.readLine();
                bufferedReader3.readLine();
                String[] split2 = bufferedReader3.readLine().split("\\*\\*");
                while (i < split2.length) {
                    String str = split2[i];
                    if (str.contains(stringExtra3 + "->" + stringExtra4)) {
                        this.f12901d = new LinkedList(Arrays.asList(split2[i].split("->")[2].split("\\*")));
                    }
                    i++;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        this.f12900c.addAll(this.f12901d);
        m16690f();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //back--ads--not--found
    }

    public class C3021a extends RecyclerView.Adapter<C3021a.C3020a> {
        final mukesh_four_jaydev f12897a;

        public C3021a(mukesh_four_jaydev iFSCListActivityVB) {
            this.f12897a = iFSCListActivityVB;
        }

        public C3020a m16686a(ViewGroup viewGroup, int i) {
            return new C3020a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mukesh_four_dec, (ViewGroup) null));
        }

        public void m16687a(C3020a c3020a, int i) {
            c3020a.f12896c.setText(this.f12897a.f12901d.get(i));
        }

        @Override
        public int getItemCount() {
            return this.f12897a.f12901d.size();
        }

        @Override
        public C3020a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return m16686a(viewGroup, i);
        }

        public void onBindViewHolder(C3020a c3020a, int i) {
            m16687a(c3020a, i);
        }

        public class C3020a extends RecyclerView.ViewHolder implements View.OnClickListener {
            final C3021a f12894a;
            public TextView f12896c;
            private LinearLayout f12895b;

            public C3020a(C3021a c3021a, View view) {
                super(view);
                f12894a = c3021a;
                f12896c = (TextView) view.findViewById(R.id.tvBankName);
                f12895b = (LinearLayout) view.findViewById(R.id.llMain);
                view.setOnClickListener(this);
            }

            public void onClick(View view) {
                Intent intent = new Intent();
                if (this.f12894a.f12897a.f12898a == 1) {
                    intent.putExtra("BANK", this.f12894a.f12897a.f12901d.get(getAdapterPosition()));
                } else if (this.f12894a.f12897a.f12898a == 2) {
                    intent.putExtra("STATE", this.f12894a.f12897a.f12901d.get(getAdapterPosition()));
                } else if (this.f12894a.f12897a.f12898a == 3) {
                    intent.putExtra("CITY", this.f12894a.f12897a.f12901d.get(getAdapterPosition()));
                } else if (this.f12894a.f12897a.f12898a == 4) {
                    intent.putExtra("BRANCH", this.f12894a.f12897a.f12901d.get(getAdapterPosition()));
                }
                this.f12894a.f12897a.setResult(-1, intent);
                this.f12894a.f12897a.finish();
            }
        }
    }
}
