package com.we.once;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.uuzuche.lib_zxing.activity.CaptureActivity;

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

                EditText money = findViewById(R.id.money);//將ＡddView的money數值傳到ＭainActivity
                Intent intent = new Intent();
                intent.setClass(AddView.this,MainActivity.class);
                intent.putExtra("MONEY",money.getText().toString());
                startActivity(intent);
            }


        });



        Button thisPageBtn = (Button)findViewById(R.id.button2);
        thisPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent1 = new Intent();
                intent1.setClass(AddView.this,AddView.class);
                startActivity(intent1);
            }


        });





        // String dateString=getIntent().getStringExtra("DATE");
        //date.setText(dateString);
    }
    public void openQRcode(View view) {
        Intent intent = new Intent(AddView.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }
}
