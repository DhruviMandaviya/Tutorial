package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    Button signIn,signUp;

    private  static final String Main_key="myPref";
    private static final String email_key="emailKey";
    private static final String password_key="passwordKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.emailId);
        password=findViewById(R.id.Password);
        signIn=findViewById(R.id.btnSignIn);
        signUp=findViewById(R.id.btnSignUp);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String EmailId=email.getText().toString();
                String Password=password.getText().toString();
                SharedPreferences preferences=getSharedPreferences(Main_key,MODE_PRIVATE);
                String UserEmail=preferences.getString(email_key,"");
                String UserPassword=preferences.getString(password_key,"");
                if(EmailId.equals(UserEmail) && Password.equals(UserPassword))
                {
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Invalid User details....",Toast.LENGTH_SHORT).show();
                }

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}