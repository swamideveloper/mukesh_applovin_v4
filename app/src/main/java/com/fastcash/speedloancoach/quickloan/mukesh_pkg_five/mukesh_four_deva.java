package com.fastcash.speedloancoach.quickloan.mukesh_pkg_five;

import android.os.SystemClock;
import android.view.View;

public abstract class mukesh_four_deva implements View.OnClickListener {

    protected int defaultInterval;
    private long lastTimeClicked = 0;

    public mukesh_four_deva() {
        this(1000);
    }

    public mukesh_four_deva(int minInterval) {
        this.defaultInterval = minInterval;
    }

    @Override
    public void onClick(View v) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return;
        }
        lastTimeClicked = SystemClock.elapsedRealtime();
        performClick(v);
    }

    public abstract void performClick(View v);
}