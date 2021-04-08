package com.example.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rajuuu.newsapps.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyCategoryAdapter extends RecyclerView.Adapter<MyCategoryAdapter.FurnitureView> {


    List<HashMap<String, Object>> furnitureList = new ArrayList<>();
    List<HashMap<String, Object>> filteredList = new ArrayList<>();

    public MyCategoryAdapter(List<HashMap<String, Object>> fList) {
        this.furnitureList = fList;
        filteredList = furnitureList;
    }

    @NonNull
    @Override
    public FurnitureView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_my_category,viewGroup,false);

        return new FurnitureView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FurnitureView furnitureView, int position) {

        HashMap<String, Object> map = filteredList.get(position);

        furnitureView.categoryImage.setImageResource((Integer) map.get("Image"));
        furnitureView.textTitle.setText(String.valueOf(map.get("Title")));

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
