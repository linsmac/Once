package com.we.once;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Spinner_main {
    private Spinner spinner;
    private final String[] kind = {"飲食", "日常用品", "交通", "娛樂", "學習深造"};
    private ArrayAdapter<String> kindList;
    private Context context;

    public Spinner_main(Context context) {
        this.context = context;
    }

    public void setSpinner(Spinner spinner){

    }
}
