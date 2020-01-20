package com.hoque.arduinoblremote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread myThread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(10000);
                    Intent intent =new Intent(getApplicationContext(), Home_Panel.class);
                    startActivity(intent);
                    finish();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent intent =new Intent(getApplicationContext(), Home_Panel.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        myThread.start();
    }
}
