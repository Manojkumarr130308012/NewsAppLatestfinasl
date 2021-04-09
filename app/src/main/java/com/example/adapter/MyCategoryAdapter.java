package com.example.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rajuuu.newsapps.Contact;
import com.rajuuu.newsapps.LatestNews;
import com.rajuuu.newsapps.R;
import com.rajuuu.newsapps.Tips;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyCategoryAdapter extends RecyclerView.Adapter<MyCategoryAdapter.FurnitureView> {


    List<HashMap<String, Object>> furnitureList = new ArrayList<>();
    List<HashMap<String, Object>> filteredList = new ArrayList<>();
    Context context;

    public MyCategoryAdapter(List<HashMap<String, Object>> fList, Context context) {
        this.furnitureList = fList;
        filteredList = furnitureList;
        this.context=context;
    }

    @NonNull
    @Override
    public FurnitureView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_my_category,viewGroup,false);

        return new FurnitureView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FurnitureView furnitureView, int position) {

        final HashMap<String, Object> map = filteredList.get(position);

        furnitureView.categoryImage.setImageResource((Integer) map.get("Image"));
        furnitureView.textTitle.setText(String.valueOf(map.get("Title")));


        furnitureView.categoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("dddddddddddddddd",""+String.valueOf(map.get("Title")));
                String titlestr=String.valueOf(map.get("Title"));
                if (titlestr.equals("News")){
                    Intent i=new Intent(context, LatestNews.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);

                }else if (titlestr.equals("Tips")){
                    Intent i=new Intent(context, Tips.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }else if (titlestr.equals("Contacts")){
                    Intent i=new Intent(context, Contact.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
                }else if (titlestr.equals("Add News")){

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }



    public class FurnitureView extends RecyclerView.ViewHolder{


        ImageView categoryImage;
        TextView textTitle;
        public FurnitureView(@NonNull View itemView) {
            super(itemView);

            categoryImage = (ImageView)itemView.findViewById(R.id.categoryImage);
            textTitle = (TextView)itemView.findViewById(R.id.categoryTitle);


        }
    }

}
