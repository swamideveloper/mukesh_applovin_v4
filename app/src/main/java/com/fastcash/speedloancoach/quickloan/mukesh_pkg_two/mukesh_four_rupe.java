package com.fastcash.speedloancoach.quickloan.mukesh_pkg_two;

import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mCountry;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mExitDialoge;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mLanguage;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mPrivacy;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mStart;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mThankYou;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_pro.Inter_Ads_Manager;


public class mukesh_four_rupe extends AppCompatActivity {

    ImageView iv_set4;
    boolean permissionFlag;
    TextView tvAccept;
    RelativeLayout rel_44;
    boolean isstorage;

    //back------------------------------------------------------------------------------------------
    boolean doubleBackToExitPressedOnce = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mukesh_four_p);

        Inter_Ads_Manager.getInstance().refreshAd(this, findViewById(R.id.native_container));
        if (getIntent().getBooleanExtra("app_inter", false)) {
            
            Inter_Ads_Manager.getInstance().displayInterstitial(this, new Inter_Ads_Manager.MyCallback() {
                @Override
                public void callbackCall() {
                }
            });
        }


        init();
        setDone();

        this.rel_44.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 33) {
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.READ_MEDIA_IMAGES") == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.READ_MEDIA_VIDEO") == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.READ_MEDIA_AUDIO") == PackageManager.PERMISSION_GRANTED) {
                        iv_set4.setImageResource(R.drawable.ic_check1);
                        isstorage = true;
                    } else {
                        setPermission();
                    }
                } else if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    iv_set4.setImageResource(R.drawable.ic_check1);
                    isstorage = true;
                } else {
                    setPermission();
                }

            }
        });

        TextView textView = (TextView) findViewById(R.id.imgStart);
        this.tvAccept = textView;

        this.tvAccept.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                goNext();
//                if (isstorage) {
//                    goNext();
//                } else {
//                    setPermission();
//                }
            }
        });
    }

    private void goNext() {
        if (mStart.equalsIgnoreCase("on")) {
            startActivity(new Intent(mukesh_four_rupe.this, mukesh_four_bardhanam.class).putExtra("app_inter", true));
        } else {
            startActivity(new Intent(mukesh_four_rupe.this, new mukesh_four_bhi().activity_X).putExtra("app_inter", true));
        }
    }

    public void setPermission() {
        if (Build.VERSION.SDK_INT >= 33) {
            ActivityCompat.requestPermissions(mukesh_four_rupe.this, new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO"}, 1000);

        } else {
            ActivityCompat.requestPermissions(mukesh_four_rupe.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);

        }
    }

    private void setDone() {
        if (Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.READ_MEDIA_IMAGES") == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.READ_MEDIA_VIDEO") == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.READ_MEDIA_AUDIO") == PackageManager.PERMISSION_GRANTED) {
            isstorage = true;
            iv_set4.setImageResource(R.drawable.ic_check1);
        } else if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            isstorage = true;
            iv_set4.setImageResource(R.drawable.ic_check1);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1000:
                if (grantResults.length > 0) {


                    if (Build.VERSION.SDK_INT >= 33) {
                        boolean readstorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                        boolean writestorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                        boolean audio = grantResults[2] == PackageManager.PERMISSION_GRANTED;
                        if (readstorage && writestorage && audio) {
                            goNext();

                        }
                    } else {
                        boolean readstorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                        boolean writestorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                        if (readstorage && writestorage) {
                            isstorage = true;
                            iv_set4.setImageResource(R.drawable.ic_check1);
                        }
                        if (readstorage && writestorage) {
                            goNext();

                        }
                    }

                }


                break;

        }
    }

    public void init() {
        this.permissionFlag = false;
        rel_44 = findViewById(R.id.rel_44);

        this.iv_set4 = findViewById(R.id.iv_set4);
    }

    @Override
    public void onBackPressed() {
        exitMode(this);
    }

    private void exitMode(Activity context) {

        if (mLanguage.equalsIgnoreCase("on")) {
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