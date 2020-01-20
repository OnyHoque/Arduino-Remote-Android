package com.hoque.arduinoblremote;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

public class ledControl extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7, button8, Discnt, Abt, b_send;

    EditText editText;

    String address = null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;

    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    String b1, b2, b3, b4, b5, b6, b7, b8;

    String b1_name, b2_name, b3_name, b4_name, b5_name, b6_name, b7_name, b8_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent new_int = getIntent();
        address = new_int.getStringExtra(DeviceList.EXTRA_ADDRESS);

        setContentView(R.layout.activity_led_control);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        b_send = (Button)findViewById(R.id.b_send);

        editText = (EditText)findViewById(R.id.editText);
        Discnt = (Button) findViewById(R.id.discnt);
        Abt = (Button) findViewById(R.id.abt);

        GetButtonData();

        new ConnectBT().execute();

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SendChar(b1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SendChar(b2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SendChar(b3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SendChar(b4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SendChar(b5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SendChar(b6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SendChar(b7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SendChar(b8);
            }
        });

        Discnt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Disconnect();
            }
        });

        Abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("com.hoque.arduinoblremote.Configuration_Panel"));
            }
        });

        b_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    String txt = editText.getText().toString();
                    editText.setText("");

                    SendChar(txt);
                }
                catch (Exception e)
                {
                    msg("Error!");
                }
            }
        });
    }

    private void SendChar(String str)
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write(str.toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error, Can not send data!");
            }
        }
    }

    private void Disconnect()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.close();
            }
            catch (IOException e)
            { msg("Error, Can not disconnect bluetooth!");}
        }
        finish();

    }

    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

    private void GetButtonData()
    {
        SharedPreferences sharedPreferences = ledControl.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);
        b1 = sharedPreferences.getString(getString(R.string.BUTTON_1), "z");
        b2 = sharedPreferences.getString(getString(R.string.BUTTON_2), "z");
        b3 = sharedPreferences.getString(getString(R.string.BUTTON_3), "z");
        b4 = sharedPreferences.getString(getString(R.string.BUTTON_4), "z");
        b5 = sharedPreferences.getString(getString(R.string.BUTTON_5), "z");
        b6 = sharedPreferences.getString(getString(R.string.BUTTON_6), "z");
        b7 = sharedPreferences.getString(getString(R.string.BUTTON_7), "z");
        b8 = sharedPreferences.getString(getString(R.string.BUTTON_8), "z");

        b1_name = sharedPreferences.getString(getString(R.string.BUTTON_1_Name), "Button 1");
        b2_name = sharedPreferences.getString(getString(R.string.BUTTON_2_Name), "Button 2");
        b3_name = sharedPreferences.getString(getString(R.string.BUTTON_3_Name), "Button 3");
        b4_name = sharedPreferences.getString(getString(R.string.BUTTON_4_Name), "Button 4");
        b5_name = sharedPreferences.getString(getString(R.string.BUTTON_5_Name), "Button 5");
        b6_name = sharedPreferences.getString(getString(R.string.BUTTON_6_Name), "Button 6");
        b7_name = sharedPreferences.getString(getString(R.string.BUTTON_7_Name), "Button 7");
        b8_name = sharedPreferences.getString(getString(R.string.BUTTON_8_Name), "Button 8");

        button1.setText(b1_name);
        button2.setText(b2_name);
        button3.setText(b3_name);
        button4.setText(b4_name);
        button5.setText(b5_name);
        button6.setText(b6_name);
        button7.setText(b7_name);
        button8.setText(b8_name);


    }

    private class ConnectBT extends AsyncTask<Void, Void, Void>
    {
        private boolean ConnectSuccess = true;

        @Override
        protected void onPreExecute()
        {
            progress = ProgressDialog.show(ledControl.this, "Connecting...", "Please wait!!!");  //show a progress dialog
        }

        @Override
        protected Void doInBackground(Void... devices) //while the progress dialog is shown, the connection is done in background
        {
            try
            {
                if (btSocket == null || !isBtConnected)
                {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//connects to the device's address and checks if it's available
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();//start connection
                }
            }
            catch (IOException e)
            {
                ConnectSuccess = false;//if the try failed, you can check the exception here
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Connection Failed. Please try again.");
                finish();
            }
            else
            {
                msg("Connected.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }
}
