package com.we.once;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.we.once.dialog.DialogDatePicker;
import com.we.once.dialog.DialogDatePickerListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class InquireActivity extends AppCompatActivity implements
        DialogDatePickerListener,
        View.OnClickListener {
    private Spinner spinner1;
    private Spinner spinner2;
    private DialogDatePicker dialogDatePicker;
    private TextView dateStartTextView;
    private TextView dateStopTextView;
    private int dateStatus;
    private final int DATE_START = 1;
    private final int DATE_STOP = 2;
    private long defaultTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquire);
        dialogDatePicker = new DialogDatePicker(this);
        dialogDatePicker.setDialogDatePickerListener(this);
        findView();
    }

    public void findView() {
        spinner1 = (Spinner) this.findViewById(R.id.spinner1);
        spinner2 = (Spinner) this.findViewById(R.id.spinner2);
        dateStartTextView = findViewById(R.id.textViewDateStart);
        dateStartTextView.setOnClickListener(this);
        dateStopTextView = findViewById(R.id.textViewDateStop);
        dateStopTextView.setOnClickListener(this);

        ImageView addPageBtn = (ImageView) findViewById(R.id.imageView7);
        addPageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent3 = new Intent();
                intent3.setClass(InquireActivity.this, AddView.class);
                startActivity(intent3);
            }


        });


        Button PageBtn = (Button) findViewById(R.id.button5);
        PageBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent1 = new Intent();
                intent1.setClass(InquireActivity.this, CheckView.class);
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
                = ArrayAdapter.createFromResource
                (this, R.array.Array_2, android.R.layout.simple_list_item_1);

        ArrayAdapter<CharSequence> adapter_spinner2
                = ArrayAdapter.createFromResource
                (this, R.array.Array_3, android.R.layout.simple_list_item_1);

        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_spinner2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


//自訂下拉式選單風格
        spinner1.setAdapter(adapter_spinner);
        spinner2.setAdapter(adapter_spinner2);
        dateStartTextView.setText(getDate());
        dateStopTextView.setText(getDate());
    }

    private String getDate(){
        Date curDate = new Date();
        defaultTime = curDate.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月");
        return formatter.format(curDate);
    }

    private String getSelectDate(int Year, int Month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Year);
        calendar.set(Calendar.MONTH, Month -1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月");
        return formatter.format(calendar.getTime());
    }

    private long getSelectTime(int Year, int Month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Year);
        calendar.set(Calendar.MONTH, Month -1);
        return calendar.getTime().getTime();
    }

    @Override
    public void onClickSelectDate(int Year, int Month) {
        if (dateStatus == DATE_START){
            dateStartTextView.setText(getSelectDate(Year, Month));
            defaultTime = getSelectTime(Year, Month);
        } else if (dateStatus == DATE_STOP){
            if (getSelectTime(Year, Month) < defaultTime){
                dateStopTextView.setText(dateStartTextView.getText());
            } else {
                dateStopTextView.setText(getSelectDate(Year, Month));
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.textViewDateStart){
            dateStatus = DATE_START;
            dialogDatePicker.show();
        } else if (view.getId() == R.id.textViewDateStop) {
            dateStatus = DATE_STOP;
            dialogDatePicker.show();
        }
    }
}