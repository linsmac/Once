package com.we.once;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button singup;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button singupBt = (Button) findViewById(R.id.button4);
        singupBt.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                Intent intent1 = new Intent();
                intent1.setClass(Login.this,SingUpActivity.class);
                startActivity(intent1);
            }


        });

    }






    public void login(View v){
        EditText edUserid = (EditText) findViewById(R.id.userid);
        EditText edPasswd = (EditText) findViewById(R.id.passwd);
        String uid = edUserid.getText().toString();
        String pw = edPasswd.getText().toString();
        if (uid.equals("jack") && pw.equals("1234")){ //登入成功
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();

            finish();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        }else{ //登入失敗
            new AlertDialog.Builder(this)
                    .setTitle("登入失敗")
                    .setMessage("請重新登入")
                    .setPositiveButton("OK", null)
                    .show();
        }



    }














   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





}*/



}
