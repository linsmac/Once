package com.we.once;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.we.once.Spinner_main;

public class MainActivity extends AppCompatActivity {
    private int mYear, mMonth, mDay;
    private Spinner spinner;
    private Spinner_main spinner_main;
    private TextView date;
    boolean logon = false;
    TextView dateTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        ImageView addPageBtn = (ImageView)findViewById(R.id.imageView3);
        addPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent();
                intent3.setClass(MainActivity.this,AddView.class);
                startActivity(intent3);
            }


        });


        ImageView inquirePageBtn = (ImageView)findViewById(R.id.inquire);
        inquirePageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this,InquireActivity.class);
                startActivity(intent1);
            }


        });



        TextView moneyback = findViewById(R.id.moneyback);//接收AddView的money數值
        Intent intent = getIntent();
        String value = intent.getStringExtra("MONEY");
        moneyback.setText(value);

        ImageView nextPageBtn = (ImageView) findViewById(R.id.plus);
        dateTextView = (TextView) findViewById(R.id.dateTextView);
        nextPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                TextView dateString = findViewById(R.id.dateTextView);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AddView.class);
                intent.putExtra("date", dateString.getText().toString());
                startActivity(intent);
            }

        });


        TextView dateString = findViewById(R.id.dateTextView);//顯示日期的TextView
        CalendarView CalendarView = findViewById(R.id.calendarView);
        CalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull android.widget.CalendarView calendarView, int i, int i1, int i2) {
                dateString.setText(+i + "年" + i1 + "月" + i2 + "日");

            }
        });


    }
    private String setDateFormat(int year, int monthOfYear, int dayOfMonth) {
        return String.valueOf(year) + "-"
                + String.valueOf(monthOfYear + 1) + "-"
                + String.valueOf(dayOfMonth);
    }








}