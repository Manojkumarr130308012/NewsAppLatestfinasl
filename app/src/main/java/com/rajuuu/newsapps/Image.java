package com.rajuuu.newsapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Image extends AppCompatActivity {
ImageView image;
String imagestr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        image=findViewById(R.id.image);

        Intent intent=getIntent();
        imagestr = intent.getStringExtra("image");


        Picasso.get().load(imagestr).placeholder(R.drawable.place_holder_big).into(image);


    }
}