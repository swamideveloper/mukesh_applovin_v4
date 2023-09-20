package com.fastcash.speedloancoach.quickloan.mukesh_pkg_two;


import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mPermission;
import static com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi.mStart;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fastcash.speedloancoach.quickloan.mukesh_pkg_nine.mukesh_four_bhi;
import com.fastcash.speedloancoach.quickloan.R;

import org.jetbrains.annotations.NotNull;

public class mukesh_four_prusti extends RecyclerView.Adapter<mukesh_four_prusti.MyHolder> {

    Activity context;
    int[] langs;


    public mukesh_four_prusti(Activity context, int[] langs) {
        this.context = context;
        this.langs = langs;

    }


    @NotNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mukesh_four_aprl, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyHolder holder, int position) {
        holder.imgCountry.setImageResource(langs[position]);
        holder.imgCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPermission.equalsIgnoreCase("on")) {
                    context.startActivity(new Intent(context, mukesh_four_rupe.class).putExtra("app_inter", true));
                } else if (mStart.equalsIgnoreCase("on")) {
                    context.startActivity(new Intent(context, mukesh_four_bardhanam.class).putExtra("app_inter", true));
                } else {
                    context.startActivity(new Intent(context, new mukesh_four_bhi().activity_X).putExtra("app_inter", true));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return langs.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView imgCountry, imgCheck;


        public MyHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgCountry = itemView.findViewById(R.id.imgCountry);
            imgCheck = itemView.findViewById(R.id.imgCheck);

        }
    }
}
