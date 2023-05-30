package com.example.sp_check1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class FourthlyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourthly_page);

        Thread thread=new Thread(){
            @Override
            public void run(){


                try {
                    sleep(2000);
                    Intent intent=new Intent(getApplicationContext(),Maps_SP.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
    }
    }
