package com.edusy.eatco.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.edusy.eatco.R;
import com.edusy.eatco.authentication.Register;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();

        Thread thread=new Thread(){
            public  void run()
            {
                try {
                    sleep(1000);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(splashscreen.this, Register.class);
                    startActivity(intent);
                    finish();
                }

            }

        };thread.start();


    }
}