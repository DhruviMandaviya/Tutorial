package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class CardListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> countries;
    DataAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        recyclerView=findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(CardListActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        countries=new ArrayList<>(Arrays.asList("India","Canada","Japan","USA","Uk","India","Canada","Japan","USA","Uk"));

        setOnclickListener();
        DataAdapter adapter=new DataAdapter(countries,CardListActivity.this,listener);
        recyclerView.setAdapter(adapter);
    }

    private void setOnclickListener() {
        listener=new DataAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v,int position) {
                Intent intent=new Intent(CardListActivity.this,ListDetaisActivity.class);
                intent.putExtra("Country",countries.get(position));
                startActivity(intent);
            }
        };
    }


}