package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GridViewActivity extends AppCompatActivity {
    GridView gridView;
    int[] image={R.drawable.panjabi,R.drawable.gujarati,R.drawable.pizza1,R.drawable.southindian,R.drawable.drinks,R.drawable.panjabi,R.drawable.gujarati,R.drawable.pizza1,R.drawable.southindian,R.drawable.drinks};
    String[] name={"This is Panjabi food","This is Gujarati food","This is Pizza","This is SouthIndian food","This is Clod Drinks ","This is Panjabi food","This is Gujarati food","This is Pizza","This is SouthIndian food","This is Clod Drinks "};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView=findViewById(R.id.GV1);
        myAdapter myAdapter=new myAdapter(name,image,GridViewActivity.this);
        gridView.setAdapter(myAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {
                Intent intent=new Intent(GridViewActivity.this,DetailActivity.class);
                intent.putExtra("image",image[i]);
                intent.putExtra("name",name[i]);
                startActivity(intent);
            }
        });
    }
}