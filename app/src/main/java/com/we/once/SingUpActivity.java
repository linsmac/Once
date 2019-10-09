package com.we.once;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SingUpActivity extends AppCompatActivity {

    //MyTask mTask = new MyTask();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);



      Button singup = (Button)findViewById(R.id.singup);
      //singup.setOnClickListener(v->insert);

    }

public  void insert(View v){
            EditText userid = (EditText)findViewById(R.id.userid);
            EditText password = (EditText)findViewById(R.id.password);
            EditText email = (EditText)findViewById(R.id.email);

            //Gson gs = new Gson();
            //String st = gs.toJson(ep);
try {
 //String encodedURL = URLEncoder.encode(st,"UTF-8");
/*    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
            .detectDiskReads()
            .detectDiskWrites()
            .detectNetwork()
            .penaltyLog()
            .build());*/
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    StrictMode.setThreadPolicy(policy);//可網路連線

    String st="userid="+userid.getText().toString()+"&passwd="+password.getText().toString()+"&email="+email.getText().toString();
   // Toast.makeText(this,userid.getText().toString(),Toast.LENGTH_LONG).show();
    String encodedURL = URLEncoder.encode(st, "UTF-8"); //要把傳進來的資料重新編碼

    String urll="http://10.10.2.41:8080/test1/RegistRecep?"+st;
    //String urll="http://10.10.2.41:8080/test1/RegistRecep?userid=xxdadx&&passwd=1234&&email=xxxxxx";
    //Toast.makeText(this,urll,Toast.LENGTH_LONG).show();
    URL url=new URL(urll);
    URLConnection conn=url.openConnection();
    InputStream is= conn.getInputStream();
    InputStreamReader rd= new InputStreamReader(is,"UTF-8");
    BufferedReader br=new BufferedReader(rd);
    String str="";
    String temp="'";
    while ((temp=br.readLine())!=null) {
        str+=temp;

    }
    Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    // mTask.execute(url);

}

catch(Exception ex){
    Log.e("urll",ex.getMessage());
}

    }



/*
   private class MyTask extends AsyncTask<String, Integer, String> {
    String TAG="MyTask Info:";
    @Override
    protected void onPreExecute() {
        Log.i(TAG, "onPreExecute() called");
    }

    //doInBackground方法內部執行幕後工作,不可在此方法內修改UI
    @Override
    protected String doInBackground(String... params) {
        Log.i(TAG, "doInBackground(Params... params) called");
        try {
            URL url=new URL(params[0]);
            URLConnection conn=url.openConnection();

            InputStream is= conn.getInputStream();
            InputStreamReader rd= new InputStreamReader(is,"UTF-8");
            BufferedReader br=new BufferedReader(rd);
            String str="";
            String temp="'";
            while ((temp=br.readLine())!=null) {
                str+=temp;
            }
            return str;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    //onProgressUpdate方法用於更新進度資訊
    @Override
    protected void onProgressUpdate(Integer... progresses) {
        Log.i(TAG, "onProgressUpdate(Progress... progresses) called");
    }

    //onPostExecute方法用於在執行完幕後工作後更新UI,顯示結果
    @Override
    protected void onPostExecute(String result) {
        Log.i(TAG, "onPostExecute(Result result) called");
        Toast.makeText(SingUpActivity.this, result,Toast.LENGTH_LONG).show();

    }

    //onCancelled方法用於在取消執行中的任務時更改UI
    @Override
    protected void onCancelled() {
        Log.i(TAG, "onCancelled() called");
    }
}*/




}
