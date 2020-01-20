package com.hoque.arduinoblremote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Panel extends AppCompatActivity {

    Button b_device, b_configuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__panel);

        b_device = (Button)findViewById(R.id.b_ConnectDevice);
        b_configuration = (Button)findViewById(R.id.b_configuration);

        b_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("com.hoque.arduinoblremote.DeviceList"));
            }
        });

        b_configuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("com.hoque.arduinoblremote.Configuration_Panel"));
            }
        });
    }
}
