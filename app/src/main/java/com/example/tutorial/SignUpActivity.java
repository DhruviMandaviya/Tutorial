package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    EditText name,email,number,password;
    Button signUp;
    private  static final String Main_key="myPref";
    private static final String name_key="nameKey";
    private static final String email_key="emailKey";
    private static final String number_key="numberKey";
    private static final String password_key="passwordKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=findViewById(R.id.userId);
        email=findViewById(R.id.email);
        number=findViewById(R.id.Contact);
        password=findViewById(R.id.Password);
        signUp=findViewById(R.id.btnSignUp);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences Preferences=getSharedPreferences(Main_key,MODE_PRIVATE);
                String userName=name.getText().toString();
                String userPassword=password.getText().toString();
                String userNumber=number.getText().toString();
                String userEmail=email.getText().toString();

                SharedPreferences.Editor editor=Preferences.edit();
                editor.putString(name_key,userName);
                editor.putString(number_key,userNumber);
                editor.putString(email_key,userEmail);
                editor.putString(password_key,userPassword);

                editor.apply();
                if(CheckUserName() && CheckUserNumber() && CheckEmailId() && CheckPassword()){
                    Intent intent=new Intent(SignUpActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(SignUpActivity.this,"Enter All info...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Boolean CheckUserName()
    {
        boolean isUsername=false;
        if(name.getText().toString().trim().length()<=0)
        {
            name.setError("Enter User Name");
        }else
        {
            isUsername=true;
        }
        return isUsername;
    }

    private Boolean CheckUserNumber()
    {
        boolean isUserNumber=false;
        if(number.getText().toString().trim().length()<=0)
        {
            number.setError("Enter Number");
        }
        else if(number.getText().toString().trim().length()==10)
        {
            isUserNumber=true;
        }
        else {
            number.setError("Enter Valid Number");
        }
        return isUserNumber;
    }
    private Boolean CheckEmailId(){
        boolean isUserEmail=false;
        if(email.getText().toString().trim().length()<=0){
            email.setError("Enter Email Id");
        }
        else if(Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches())
        {
            isUserEmail=true;
        }
        else {
            email.setError("Enter valid Email Id");
        }
        return isUserEmail;
    }

    private Boolean CheckPassword(){
        boolean isUserPassword=false;
        final String Password_pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,}$";
        if(password.getText().toString().trim().length()<=0)
        {
            password.setError("Enter Password");
        }
        else if(Pattern.compile(Password_pattern).matcher(password.getText().toString().trim()).matches()){
            isUserPassword=true;
        }
        else
        {
            password.setError("Enter at least one digit,one lower case letter,one upper case letter,one special\n" +
                    "character and length must be 5");
        }
        return isUserPassword;
    }
}