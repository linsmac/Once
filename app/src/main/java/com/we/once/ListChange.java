package com.we.once;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ListChange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_change);

        ImageView linepg = (ImageView)findViewById(R.id.linechart4);
        linepg.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent4 = new Intent();
                intent4.setClass(ListChange.this,LineChart.class);
                startActivity(intent4);
            }


        });




        ImageView piepg = (ImageView)findViewById(R.id.piechart3);
        piepg.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent();
                intent3.setClass(ListChange.this,CheckView.class);
                startActivity(intent3);
            }


        });



    }

}
