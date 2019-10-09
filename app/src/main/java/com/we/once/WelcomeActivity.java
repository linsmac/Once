package com.we.once;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class WelcomeActivity extends AppCompatActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);
            mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2000); //2秒跳轉
        }
        private static final int GOTO_MAIN_ACTIVITY = 0;
        private Handler mHandler = new Handler() {
            public void handleMessage(android.os.Message msg) {

                switch (msg.what) {
                    case GOTO_MAIN_ACTIVITY:
                        Intent intent = new Intent();

                        intent.setClass(WelcomeActivity.this, Login.class);
                        startActivity(intent);
                        finish();
                        break;

                    default:
                        break;
                }
            }

        };
    }

