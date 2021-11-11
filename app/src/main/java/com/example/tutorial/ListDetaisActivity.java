package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ListDetaisActivity extends AppCompatActivity {
    TextView ListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detais);

        ListDetail=findViewById(R.id.tv_country);

        Intent intent=getIntent();
        String name=intent.getStringExtra("Country");
        ListDetail.setText(name);
    }
}