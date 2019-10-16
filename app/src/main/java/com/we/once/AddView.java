package com.we.once;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AddView extends AppCompatActivity {

    private EditText money;
    private final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);



        ImageView mainPageBtn = (ImageView)findViewById(R.id.mainpg2);
        mainPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent1 = new Intent();
                intent1.setClass(AddView.this,MainActivity.class);
                startActivity(intent1);
            }


        });

        ImageView inquirePageBtn = (ImageView)findViewById(R.id.inquire4);
        inquirePageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent2 = new Intent();
                intent2.setClass(AddView.this,InquireActivity.class);
                startActivity(intent2);
            }


        });

        TextView date = findViewById(R.id.date);//接收ＭainActivity的數值到ＡddView
        Intent intent = getIntent();
        String value = intent.getStringExtra("date");
        date.setText(value);


        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        final String[] kind = {"飲食","交通","日常生活","娛樂","交通","其他"};
        ArrayAdapter<String> kindList = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,kind);
        spinner.setAdapter(kindList);


        Button nextPageBtn = (Button)findViewById(R.id.button5);
        nextPageBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {

                    TextView eindate = (TextView)findViewById(R.id.date);
                    EditText totalprice = (EditText)findViewById(R.id.money);

                    EditText note = (EditText)findViewById(R.id.editText6);

                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);//可網路連線

                    String st="eindate="+eindate.getText().toString()+"&totalprice="+totalprice.getText().toString()+"&note="+note.getText().toString()+"&sortID=1";

                    // Toast.makeText(this,userid.getText().toString(),Toast.LENGTH_LONG).show();
                    // String encodedURL = URLEncoder.encode(st, "UTF-8"); //要把傳進來的資料重新編碼

                    String urll="http://10.10.2.122:8080/eInv/AddManual?"+st;
                    //Toast.makeText(this,urll,Toast.LENGTH_LONG).show();
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
                    //Toast.makeText(this,str,Toast.LENGTH_LONG).show();




                    EditText money = findViewById(R.id.money);//將ＡddView的money數值傳到ＭainActivity
                    Intent intent = new Intent();
                    intent.setClass(AddView.this,MainActivity.class);
                    //intent.putExtra("MONEY",money.getText().toString());
                    intent.putExtra("MONEY",str);

                    startActivity(intent);
                }

                catch(Exception ex){
                    Log.e("urll",ex.getMessage());
                }
            }


        });



       /* Button thisPageBtn = (Button)findViewById(R.id.button2);
        thisPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent1 = new Intent();
                intent1.setClass(AddView.this,AddView.class);
                startActivity(intent1);
            }


        });*/





        // String dateString=getIntent().getStringExtra("DATE");
        //date.setText(dateString);
    }
    public void openQRcode(View view) {
        Intent intent = new Intent(AddView.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }










 /*   public void add(View view){
        try {

            TextView eindate = (TextView)findViewById(R.id.date);
            EditText totalprice = (EditText)findViewById(R.id.money);

            EditText note = (EditText)findViewById(R.id.editText6);

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);//可網路連線

           String st="eindate="+eindate.getText().toString()+"&totalprice="+totalprice.getText().toString()+"&note="+note.getText().toString()+"&sortID=1";

            // Toast.makeText(this,userid.getText().toString(),Toast.LENGTH_LONG).show();
           // String encodedURL = URLEncoder.encode(st, "UTF-8"); //要把傳進來的資料重新編碼

            String urll="http://10.10.2.122:8080/eInv/AddManual?"+st;
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

    }*/


}
