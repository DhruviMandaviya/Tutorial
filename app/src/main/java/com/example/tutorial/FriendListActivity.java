package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FriendListActivity extends AppCompatActivity {
    ListView lv;
    String Name[]={"Dhruvi","siddhi","shraddha","riddhi","riya","hima","chhaya","pintu","nisha","twinkal","shivu","vedu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        lv= findViewById(R.id.lv);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Name);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {
                Toast.makeText(FriendListActivity.this,"your friend name is "+Name[i],Toast.LENGTH_SHORT).show();
            }
        });

    }
}