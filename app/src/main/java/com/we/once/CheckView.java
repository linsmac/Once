package com.we.once;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CheckView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_view);




        ImageView addPageBtn = (ImageView)findViewById(R.id.imageView11);
        addPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent();
                intent3.setClass(CheckView.this,AddView.class);
                startActivity(intent3);
            }


        });



        ImageView mainPageBtn = (ImageView)findViewById(R.id.imageView10);
        mainPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent1 = new Intent();
                intent1.setClass(CheckView.this,MainActivity.class);
                startActivity(intent1);
            }


        });

        ImageView inquirePageBtn = (ImageView)findViewById(R.id.inquire3);
        inquirePageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent2 = new Intent();
                intent2.setClass(CheckView.this,InquireActivity.class);
                startActivity(intent2);
            }


        });
    }
}
