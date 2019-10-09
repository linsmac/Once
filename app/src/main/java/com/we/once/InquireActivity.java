package com.we.once;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class InquireActivity extends AppCompatActivity {
        Spinner spinner1;
        Spinner spinner2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_inquire);
            findView();


            ImageView addPageBtn = (ImageView)findViewById(R.id.imageView7);
            addPageBtn.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {


                    Intent intent3 = new Intent();
                    intent3.setClass(InquireActivity.this,AddView.class);
                    startActivity(intent3);
                }


            });


            Button PageBtn = (Button)findViewById(R.id.button5);
            PageBtn.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {


                    Intent intent1 = new Intent();
                    intent1.setClass(InquireActivity.this,CheckView.class);
                    startActivity(intent1);
                }


            });


            ImageView MainPageBtn = (ImageView) findViewById(R.id.mainpg);
            MainPageBtn.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    Intent intent = new Intent();
                    intent.setClass(InquireActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            });



            ArrayAdapter<CharSequence> adapter_spinner
                    =ArrayAdapter.createFromResource
                    (this,R.array.Array_2,android.R.layout.simple_list_item_1);

            ArrayAdapter<CharSequence>adapter_spinner2
                    =ArrayAdapter.createFromResource
                    (this,R.array.Array_3,android.R.layout.simple_list_item_1);

            adapter_spinner.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
            adapter_spinner2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


//自訂下拉式選單風格
            spinner1.setAdapter(adapter_spinner);
            spinner2.setAdapter(adapter_spinner2);


        }

        public void findView()
        {

            spinner1=(Spinner) this.findViewById(R.id.spinner1);
            spinner2=(Spinner) this.findViewById(R.id.spinner2);
        }






    }