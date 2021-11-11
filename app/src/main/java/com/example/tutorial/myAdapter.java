package com.example.tutorial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myAdapter extends BaseAdapter {

    String[] name;
    int[] image;
    Context context;
    LayoutInflater layoutInflater;

    public myAdapter(String[] name,int[] image,Context context) {
        this.name = name;
        this.image = image;
        this.context = context;
        layoutInflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i,View view,ViewGroup viewGroup) {
        view=layoutInflater.inflate(R.layout.row_listview,null);
        ImageView imageView=view.findViewById(R.id.ImageView);
        TextView textView=view.findViewById(R.id.TextView);
        imageView.setImageResource(image[i]);
        textView.setText(name[i]);
        return view;
    }
}
