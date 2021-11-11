package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView im1;
    TextView tv1;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        im1=findViewById(R.id.im1);
        tv1=findViewById(R.id.tv1);

        Intent intent=getIntent();
        int image=intent.getIntExtra("image",R.id.im1);
        String name=intent.getStringExtra("name");
        im1.setImageResource(image);
        tv1.setText(name);

        anim= AnimationUtils.loadAnimation(DetailActivity.this,R.anim.frad_in);
        im1.setAnimation(anim);
    }
}