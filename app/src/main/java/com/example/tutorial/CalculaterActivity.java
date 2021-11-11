package com.example.tutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class CalculaterActivity extends AppCompatActivity implements View.OnClickListener {
    Button sum ,mul ,min,div, Contact;
    EditText et1,et2;
    TextView tvans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculater);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sum=findViewById(R.id.sum);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);
        min=findViewById(R.id.min);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        tvans=findViewById(R.id.ans);
        Contact=findViewById(R.id.Contact);

        sum.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        min.setOnClickListener(this);

        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View view) {

        String num1=et1.getText().toString();
        String num2=et2.getText().toString();
        String ans;

        int n1=Integer.parseInt(num1);
        int n2=Integer.parseInt(num2);

        int sum1=n1+n2;
        int mul1=n1*n2;
        int div1=n1/n2;
        int min1=n1-n2;

        switch (view.getId())
        {
            case R.id.sum:
                ans=String.valueOf(sum1);
                tvans.setText(ans);
                break;
            case R.id.mul:
                ans = String.valueOf(mul1);
                tvans.setText(ans);
                break;
            case R.id.div:
                ans = String.valueOf(div1);
                tvans.setText(ans);
                break;
            case R.id.min:
                ans = String.valueOf(min1);
                tvans.setText(ans);
                break;
        }
    }
}