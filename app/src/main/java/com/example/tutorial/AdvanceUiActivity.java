package com.example.tutorial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class AdvanceUiActivity extends AppCompatActivity {
    Spinner spinner;
    Switch Switch;
    ToggleButton tg;
    TextView status,progressStatus,tvDate,tvTime,tvResult,tvRatResult;
    Button start;
    ProgressBar pc;
    ImageButton time,date;
    int i;
    Handler handler= new Handler();
    String[] city ={"NAVSARI","SURAT","Vyara","VASAD","VAPI"};
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    SeekBar seekBar;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_ui);
        spinner=findViewById(R.id.spinner);
        Switch=findViewById(R.id.switch1);
        tg=findViewById(R.id.tg1);
        status=findViewById(R.id.status);
        pc=findViewById(R.id.progress);
        progressStatus=findViewById(R.id.progressStatus);
        start=findViewById(R.id.start);
        date=findViewById(R.id.Date);
        time=findViewById(R.id.Time);
        tvDate=findViewById(R.id.TvDate);
        tvTime=findViewById(R.id.TvTime);
        tvResult=findViewById(R.id.tvResult);
        seekBar=findViewById(R.id.seekBar);
        ratingBar=findViewById(R.id.RatingBar);
        tvRatResult=findViewById(R.id.tvRatResult);
        Calendar calendar=Calendar.getInstance();

        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        final int month=calendar.get(Calendar.MONTH);
        final int year=calendar.get(Calendar.YEAR);
        final int hour=calendar.get(Calendar.HOUR);
        final int minute=calendar.get(Calendar.MINUTE);

        //Date DialogBox
        date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                datePickerDialog= new DatePickerDialog(AdvanceUiActivity.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker,int i,int i1,int i2) {
                        tvDate.setText(i2+"/"+(i1+1)+"/"+i);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        //Time dialogBox
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog=new TimePickerDialog(AdvanceUiActivity.this,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker,int i,int i1) {
                        tvTime.setText(i+":"+i1);
                    }
                },hour,minute,true);
                timePickerDialog.show();
            }
        });

        //seekBar
        tvResult.setText(seekBar.getProgress()+"/"+seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress=0;
            @Override
            public void onProgressChanged(SeekBar seekBar,int i,boolean b) {
                progress=i;
                tvResult.setText(progress+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(AdvanceUiActivity.this,"start...",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(AdvanceUiActivity.this,"Stop...",Toast.LENGTH_SHORT).show();
            }
        });


        //RatingBar
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            int max_stars=ratingBar.getNumStars();
            float selected_stars=ratingBar.getRating();
            @Override
            public void onRatingChanged(RatingBar ratingBar,float v,boolean b) {
                selected_stars=v;
                tvRatResult.setText(selected_stars+"/"+max_stars);
            }
        });


        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,View view,int i,long l) {
                Toast.makeText(AdvanceUiActivity.this,"Your city is "+city[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton,boolean b) {
                if(b)
                {
                    Toast.makeText(AdvanceUiActivity.this,""+Switch.getTextOn().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AdvanceUiActivity.this,""+Switch.getTextOff().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        tg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton,boolean b) {
                if(b)
                {
                    status.setText(tg.getTextOn().toString());
                }
                else
                {
                    status.setText(tg.getTextOff().toString());
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=pc.getProgress();
                 new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (i<100)
                        {
                            i+=5;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    pc.setProgress(i);
                                    progressStatus.setText(i + "/"+pc.getMax());
                                }
                            });

                            Intent intent= new Intent(AdvanceUiActivity.this,FriendListActivity.class);
                            startActivity(intent);

                            //Speed manage of progress bar
                           /* try {
                                Thread.sleep(1000);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/
                        }
                    }

                }).start();
            }

        });
    }
}