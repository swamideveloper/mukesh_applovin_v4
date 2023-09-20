package com.fastcash.speedloancoach.quickloan.mukesh_pkg_one;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_twelve.mukesh_four_rath;
import com.fastcash.speedloancoach.quickloan.R;
import com.fastcash.speedloancoach.quickloan.mukesh_pkg_eleven.mukesh_four_dev;

import java.util.ArrayList;

public class mukesh_four_dil extends RecyclerView.Adapter<mukesh_four_dil.ViewHolder> {
    public Context activity;
    private int ITEM_DATA = 0;
    private ArrayList<mukesh_four_rath> list;


    public mukesh_four_dil(Activity activity2, ArrayList<mukesh_four_rath> arrayList) {
        this.activity = activity2;
        this.list = arrayList;
    }

    @NonNull
    @Override
    public mukesh_four_dil.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mukesh_four_y, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mukesh_four_dil.ViewHolder holder, int position) {
        mukesh_four_rath SFLoanBankDetails = this.list.get(position);
        Glide.with(this.activity).load(SFLoanBankDetails.getImage()).apply(new RequestOptions().error(R.drawable.ic_launcher)).thumbnail(Glide.with(this.activity).load(R.drawable.ic_loading_gif)).into(holder.imgIcon);
        holder.tvName.setText(SFLoanBankDetails.getTitle());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity.getApplicationContext(), mukesh_four_dev.class);
                intent.putExtra("image", SFLoanBankDetails.getImage());
                intent.putExtra("NAME", SFLoanBankDetails.getName());
                intent.putExtra("number", SFLoanBankDetails.getNumber());
                activity.startActivity(intent);
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filterList(ArrayList<mukesh_four_rath> arrayList) {
        this.list = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    @Override
    public int getItemViewType(int i) {
        return this.ITEM_DATA;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgIcon;
        public LinearLayout linearLayout;
        public TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            this.imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            this.tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}

