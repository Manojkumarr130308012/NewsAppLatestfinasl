package com.rajuuu.newsapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TipsApplcation extends AppCompatActivity {
    ImageView image_news;
    TextView txt_title,description;

    String imagestr,titlestr,desstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_applcation);

        image_news=findViewById(R.id.image_news);
        txt_title=findViewById(R.id.txt_title);
        description=findViewById(R.id.description);


        Intent intent = getIntent();
        imagestr = intent.getStringExtra("image");
        titlestr = intent.getStringExtra("title");
        desstr = intent.getStringExtra("description");

        Picasso.get().load(imagestr).placeholder(R.drawable.place_holder_big).into(image_news);
        txt_title.setText(""+titlestr);
        description.setText(Html.fromHtml(desstr));


        image_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TipsApplcation.this,Image.class);
                intent.putExtra("image",imagestr);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }
}