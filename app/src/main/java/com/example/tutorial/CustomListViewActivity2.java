package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

public class CustomListViewActivity2 extends AppCompatActivity {

    ListView LV1;
    int[] image={R.drawable.panjabi,R.drawable.gujarati,R.drawable.pizza1,R.drawable.southindian,R.drawable.drinks};
    String[] name={"This is Panjabi food","This is Gujarati food","This is Pizza","This is SouthIndian food","This is Clod Drinks "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view2);
        LV1=findViewById(R.id.LV1);

        myAdapter Adapter=new myAdapter(name,image,CustomListViewActivity2.this);
        LV1.setAdapter(Adapter);

        LV1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {

                Intent intent=new Intent(CustomListViewActivity2.this,DetailActivity.class);
                intent.putExtra("image",image[i]);
                intent.putExtra("name",name[i]);
                startActivity(intent);

            }
        });
    }
}