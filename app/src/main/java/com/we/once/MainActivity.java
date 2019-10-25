package com.we.once;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
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
       // qrcodeA("");

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
                dateString.setText(+i + "-" + (i1+1) + "-" + i2 );

            }
        });

    }

    public void openQRcode(View view) {
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    private String getDateFormat(long time) {
        Date curDate = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
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
                   // qrcode(result);


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
/*
    public void qrcodeA(String qrcodestring){
        String test = "UQ4865549810810044400000000320000003200000032843067709/QXXDRKBaf7qwugjrXwXw==:**********:2:3:1:C美式辣雞堡:1:22:C可樂_小:1:28:";
         try {
            Log.v("塞塞", "str =" + URLEncoder.encode(test, "UTF-8")); //要把傳進來的資料重新編碼)
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }*/

    /*public void qrcode(String qrcodestring){
        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);//可網路連線

            //String st=.getText().toString();
            // Toast.makeText(this,userid.getText().toString(),Toast.LENGTH_LONG).show();
             String encodedURL = URLEncoder.encode(qrcodestring, "UTF-8"); //要把傳進來的資料重新編碼

            String urll="http://10.10.2.122:8080/eInv/ScanQrcode?str="+qrcodestring+encodedURL;
            Toast.makeText(this,urll,Toast.LENGTH_LONG).show();
            URL url=new URL(urll);
            URLConnection conn=url.openConnection();
            InputStream is= conn.getInputStream();
            InputStreamReader rd= new InputStreamReader(is,"UTF-8");
            BufferedReader br=new BufferedReader(rd);
            String str="";
            String temp="'";
            while ((temp=br.readLine())!=null) {
                str+=temp;

            }
            Toast.makeText(this,str,Toast.LENGTH_LONG).show();


        }

        catch(Exception ex){
            Log.e("urll",ex.getMessage());
        }

    }
*/


}


