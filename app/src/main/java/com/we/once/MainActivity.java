package com.we.once;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.we.once.Spinner_main;

import java.text.SimpleDateFormat;
import java.util.Date;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    private int mYear, mMonth, mDay;
    private Spinner spinner;
    private Spinner_main spinner_main;
    private TextView date;

    boolean logon = false;
    TextView dateTextView;

    private final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPermissionsCamera();
        findView();

    }
    public void   getPermissionsCamera(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);

        }

    }

    public void findView() {
        ImageView addPageBtn = (ImageView) findViewById(R.id.imageView3);
        dateTextView = (TextView) findViewById(R.id.dateTextView);
        addPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View view) {

                TextView dateString = findViewById(R.id.dateTextView);
                Intent intent3 = new Intent();
                intent3.setClass(MainActivity.this, AddView.class);
                intent3.putExtra("date", dateString.getText().toString());
                startActivity(intent3);
            }


        });


        ImageView inquirePageBtn = (ImageView) findViewById(R.id.inquire);

        inquirePageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this, InquireActivity.class);
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
        dateString.setText(getDateFormat(CalendarView.getDate()));
        CalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull android.widget.CalendarView calendarView, int i, int i1, int i2) {
                dateString.setText(+i + "年" + i1 + "月" + i2 + "日");

            }
        });

    }

    public void openQRcode(View view) {
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    private String getDateFormat(long time) {
        Date curDate = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        return formatter.format(curDate);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
//                    Uri content_url = Uri.parse(result.toString());
//                    intent.setData(content_url);
                    Toast.makeText(MainActivity.this,
                            result, Toast.LENGTH_LONG).show();
                    startActivity(intent);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE)
                        == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this,
                            "解析二維碼失敗", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


}