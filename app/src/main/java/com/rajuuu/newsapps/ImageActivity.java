package com.rajuuu.newsapps;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.util.Constant;
import com.example.util.JsonUtils;
import com.example.util.TouchImageView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class ImageActivity extends AppCompatActivity {

    Toolbar toolbar;
    JsonUtils jsonUtils;
    TouchImageView imageView;
    ViewPager mViewPager;
    CustomViewPagerAdapter mAdapter;
    TextView textViewClose;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);

        textViewClose=findViewById(R.id.txt_close);

        jsonUtils = new JsonUtils(this);
        jsonUtils.forceRTLIfSupported(getWindow());

        mViewPager = findViewById(R.id.viewPager);
        mAdapter = new CustomViewPagerAdapter();
        mViewPager.setAdapter(mAdapter);
        textViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private class CustomViewPagerAdapter extends PagerAdapter {
        private LayoutInflater inflater;

        public CustomViewPagerAdapter() {
            // TODO Auto-generated constructor stub
            inflater = getLayoutInflater();
        }

        @Override
        public int getCount() {
            return Constant.ConsImage.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View imageLayout = inflater.inflate(R.layout.row_full_gallery_item, container, false);
            assert imageLayout != null;



            TouchImageView image = imageLayout.findViewById(R.id.iv_wall_details);
            TextView text = imageLayout.findViewById(R.id.textNumber);
            YouTubePlayerView youtube_view = imageLayout.findViewById(R.id.activity_main_youtubePlayerView);
            getLifecycle().addObserver(youtube_view);

            text.setText(position + 1 + "/" + Constant.ConsImage.size());
            if (Constant.ConsImage.get(position).getGaType().equals("video")){
                image.setVisibility(View.GONE);
                youtube_view.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        youTubePlayer.loadVideo(Constant.ConsImage.get(position).getGaPlayId(), 0);
                    }
                });
//                Picasso.get().load(Constant.YOUTUBE_IMAGE_FRONT+Constant.ConsImage.get(position).getGaPlayId()+Constant.YOUTUBE_SMALL_IMAGE_BACK).placeholder(R.mipmap.app_icon).into(image);
            }else {
                youtube_view.setVisibility(View.GONE);
                Picasso.get().load(Constant.ConsImage.get(position).getGaImage()).placeholder(R.mipmap.app_icon).into(image);
            }


//
//            text.setText(position + 1 + "/" + Constant.ConsImage.size());
//            if (Constant.ConsImage.get(position).getGaType().equals("video")){
//                Picasso.get().load(Constant.YOUTUBE_IMAGE_FRONT+Constant.ConsImage.get(position).getGaPlayId()+Constant.YOUTUBE_SMALL_IMAGE_BACK).placeholder(R.mipmap.app_icon).into(image);
//            }else {
//                Picasso.get().load(Constant.ConsImage.get(position).getGaImage()).placeholder(R.mipmap.app_icon).into(image);
//            }


            container.addView(imageLayout, 0);
            return imageLayout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            (container).removeView((View) object);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
