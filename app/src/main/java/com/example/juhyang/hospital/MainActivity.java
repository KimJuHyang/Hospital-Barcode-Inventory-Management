package com.example.juhyang.hospital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.widget.EditText;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    private  static int progress_percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                startActivity(new Intent(MainActivity.this, login.class));
                finish();
            }
        };
        //3초 후 화면 전환



        ProgressBar progress = (ProgressBar) findViewById(R.id.progress);
        progress_percent = 0;

        final Intent intent = new Intent(MainActivity.this, login.class);

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        while (!Thread.currentThread().isInterrupted()){
                            progress_percent += 20;
                            Thread.sleep(1000);
                            ProgressBar progress = (ProgressBar) findViewById(R.id.progress);
                            progress.setProgress(progress_percent);

                            if (progress_percent >= 100) {
                                startActivity(intent);
                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                currentThread().interrupt();

                            }
                        }
                    } catch (Throwable t) {

                    } finally {

                    }
                }
            }
        }.start();

    }


}





