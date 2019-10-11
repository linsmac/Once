package com.we.once.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.we.once.R;
import com.ycuwq.datepicker.date.DatePicker;

public class DialogDatePicker extends AlertDialog implements View.OnClickListener{
    private DatePicker datePicker;
    private DialogDatePickerListener dialogDatePickerListener;
    private Button buttonCancel;
    private Button buttonConfirm;

    public DialogDatePicker(@NonNull Context context) {
        super(context);
    }

    public DialogDatePicker(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public void setDialogDatePickerListener(DialogDatePickerListener listener) {
        this.dialogDatePickerListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_date);
        findView();
    }

    private void findView() {
        datePicker = findViewById(R.id.datePicker);
        datePicker.getDayPicker().setVisibility(View.GONE);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(this);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonCancel){
            this.dismiss();
        } else {
            Log.v("Vincent", "datePicker = " + datePicker.getDate());
            dialogDatePickerListener.onClickSelectDate(datePicker.getYear(), datePicker.getMonth());
            this.dismiss();
        }
    }
}
