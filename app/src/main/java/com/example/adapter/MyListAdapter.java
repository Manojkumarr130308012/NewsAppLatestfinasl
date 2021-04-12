package com.example.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.item.MyListData;
import com.rajuuu.newsapps.R;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private List<MyListData> listdata;
Context context;
    // RecyclerView recyclerView;
    public MyListAdapter(List<MyListData> listdata, Context context) {
        this.listdata = listdata;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final MyListData myListData = listdata.get(position);
        holder.textView.setText(listdata.get(position).getReporter_name());
        holder.textView1.setText(listdata.get(position).getReporter_city());
        holder.textView2.setText(listdata.get(position).getReporter_mobile());
        holder.imageView.setImageResource(listdata.get(position).getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getReporter_id(),Toast.LENGTH_LONG).show();
            }
        });
        final String mobileno=""+listdata.get(position).getReporter_mobile();

        holder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+mobileno));
                context.startActivity(intent);
            }

        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ImageView imageView1;
        public TextView textView;
        public TextView textView1;
        public TextView textView2;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.textView1 = (TextView) itemView.findViewById(R.id.textView1);
            this.textView2= (TextView) itemView.findViewById(R.id.textView2);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}