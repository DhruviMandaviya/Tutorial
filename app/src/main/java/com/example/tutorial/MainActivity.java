package com.example.tutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button scroll,btnLogout;
    AutoCompleteTextView autoCompleteTextView;
    String[] name ={"Dhruvi","dhruti","dhrumil","dhrutik","Chhaya"};
    TextView Name,Email,Number;
    private  static final String Main_key="myPref";
    private static final String name_key="nameKey";
    private static final String email_key="emailKey";
    private static final String number_key="numberKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView=findViewById(R.id.etName);
        Name=findViewById(R.id.UserName);
        Number=findViewById(R.id.Number);
        Email=findViewById(R.id.Email);
        btnLogout=findViewById(R.id.btnLogout);
        final SharedPreferences preferences=getSharedPreferences(Main_key,MODE_PRIVATE);

        String UserName=preferences.getString(name_key,"");
        String UserNumber=preferences.getString(number_key,"");
        String UserEmail=preferences.getString(email_key,"");
        Name.setText("User Name: "+UserName);
        Number.setText("User Number: "+UserNumber);
        Email.setText("User Email ID: "+UserEmail);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=preferences.edit();
                editor.clear();
                editor.apply();
                finish();
            }
        });



        scroll=findViewById(R.id.scroll);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);

        scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertBox= new AlertDialog.Builder(MainActivity.this);
                alertBox.setMessage("Enter your name first");
                alertBox.setTitle("Alert Message");

                alertBox.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface,int i) {
                        Toast.makeText(MainActivity.this,"Thanks, for enter name",Toast.LENGTH_SHORT).show();
                        String name=autoCompleteTextView.getText().toString();
                        Intent intent= new Intent(MainActivity.this,scrollviewActivity.class);
                        intent.putExtra("Name",name);
                        startActivity(intent);
                    }
                });

                alertBox.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface,int i) {
                        Toast.makeText(MainActivity.this,"Enter your name first",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog=alertBox.create();
                alertDialog.show();



            }
        });
        Log.d("DHRUVI","OnCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("DHRUVI","OnPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("DHRUVI","OnStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("DHRUVI","OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("DHRUVI","OnDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("DHRUVI","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DHRUVI","onResume");
    }

    public void GoToCounting(View view) {
        Intent intent= new Intent(MainActivity.this,CalculaterActivity.class);
        startActivity(intent);
    }

    public void GoToAdvance(View view) {
        Intent intent= new Intent(MainActivity.this,AdvanceUiActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.new_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.friendList:
                Intent intent1= new Intent(MainActivity.this,scrollviewActivity.class);
                startActivity(intent1);
                break;
            case R.id.Calculator:
                Intent intent2= new Intent(MainActivity.this,CalculaterActivity.class);
                startActivity(intent2);
                break;
            case R.id.Advance_Ui:
                Intent intent3= new Intent(MainActivity.this,AdvanceUiActivity.class);
                startActivity(intent3);
                break;
            case R.id.Toast:
                LayoutInflater layoutInflater=getLayoutInflater();
                View view=layoutInflater.inflate(R.layout.toast,(ViewGroup)findViewById(R.id.LL1));
                Toast toast=new Toast(MainActivity.this);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(view);
                toast.show();
                break;
            case R.id.CustomView:
                Intent intent4= new Intent(MainActivity.this,CustomListViewActivity2.class);
                startActivity(intent4);
                break;
            case R.id.GridView:
                Intent intent5= new Intent(MainActivity.this,GridViewActivity.class);
                startActivity(intent5);
                break;
            case R.id.recyclerView:
                Intent intent6= new Intent(MainActivity.this,CardListActivity.class);
                startActivity(intent6);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}