package com.we.once;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class CheckView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_view);


        PieChartView pieChartView = findViewById(R.id.chart);


        List<SliceValue> pieData = new ArrayList<>();

        pieData.add(new SliceValue(25,getResources().getColor(R.color.c1,null)).setLabel("飲食"));
        pieData.add(new SliceValue(57,getResources().getColor(R.color.c2,null)).setLabel("交通"));
        pieData.add(new SliceValue(22,getResources().getColor(R.color.c3,null)).setLabel("日常生活"));
        pieData.add(new SliceValue(80,getResources().getColor(R.color.c4,null)).setLabel("娛樂"));
        pieData.add(new SliceValue(100,getResources().getColor(R.color.c5,null)).setLabel("醫療"));
        pieData.add(new SliceValue(15,getResources().getColor(R.color.c6,null)).setLabel("其他"));

        PieChartData pieChartData = new PieChartData(pieData);

        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("看你花的多兇嘖嘖").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));

        pieChartView.setPieChartData(pieChartData);








/*

        ImageView addPageBtn = (ImageView)findViewById(R.id.imageView11);
        addPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent();
                intent3.setClass(CheckView.this,AddView.class);
                startActivity(intent3);
            }


        });
*/



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

        ImageView linechartpage = (ImageView)findViewById(R.id.linechart);
        linechartpage.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent();
                intent3.setClass(CheckView.this,LineChart.class);
                startActivity(intent3);
            }


        });
        ImageView rigthpge = (ImageView)findViewById(R.id.right);
        rigthpge.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent4 = new Intent();
                intent4.setClass(CheckView.this,LineChart.class);
                startActivity(intent4);
            }


        });

    }
}
