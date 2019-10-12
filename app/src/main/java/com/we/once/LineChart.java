package com.we.once;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class LineChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        List lines = new ArrayList();



        ImageView mainPageBtn = (ImageView)findViewById(R.id.mainPG);
        mainPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent = new Intent();
                intent.setClass(LineChart.this,MainActivity.class);
                startActivity(intent);
            }


        });

        ImageView inquirePageBtn = (ImageView)findViewById(R.id.inquire5);
        inquirePageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent2 = new Intent();
                intent2.setClass(LineChart.this,InquireActivity.class);
                startActivity(intent2);
            }


        });



        ImageView piechartPageBtn = (ImageView)findViewById(R.id.piechart);
        piechartPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent();
                intent3.setClass(LineChart.this,CheckView.class);
                startActivity(intent3);
            }


        });



        LineChartView lineChartView = findViewById(R.id.chart);

        String[] axisData = {"飲食", "交通", "生活用品", "䱷樂", "醫療", "其他"};
        int[] yAxisData = {50, 200, 600, 120, 40, 100 };
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();
       // Line line = new Line(yAxisValues);
        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0"));

        for(int i = 0; i < axisData.length; i++){
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++){
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }


        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);
        lineChartView.setLineChartData(data);


        Axis axis = new Axis();
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);

        axis.setTextSize(16);
        yAxis.setTextColor(Color.parseColor("#03A9F4"));

        axis.setTextColor(Color.parseColor("#03A9F4"));
        //yAxis.setTextColor(Color.parseColor("#03A9F4"));
        //yAxis.setTextSize(16);
       // yAxis.setName("越高花越多");
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
       // viewport.top =1000;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);

    }




}
