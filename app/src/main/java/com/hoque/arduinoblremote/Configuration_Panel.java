package com.hoque.arduinoblremote;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Configuration_Panel extends AppCompatActivity {

    EditText b1_ch, b2_ch, b3_ch, b4_ch, b5_ch, b6_ch, b7_ch, b8_ch;
    EditText b1_n, b2_n, b3_n, b4_n, b5_n, b6_n, b7_n, b8_n;
    Button b_save;

    String b1, b2, b3, b4, b5, b6, b7, b8;
    String b1_name, b2_name, b3_name, b4_name, b5_name, b6_name, b7_name, b8_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration__panel);

        b1_ch = (EditText)findViewById(R.id.edit_b1_ch);
        b2_ch = (EditText)findViewById(R.id.edit_b2_ch);
        b3_ch = (EditText)findViewById(R.id.edit_b3_ch);
        b4_ch = (EditText)findViewById(R.id.edit_b4_ch);
        b5_ch = (EditText)findViewById(R.id.edit_b5_ch);
        b6_ch = (EditText)findViewById(R.id.edit_b6_ch);
        b7_ch = (EditText)findViewById(R.id.edit_b7_ch);
        b8_ch = (EditText)findViewById(R.id.edit_b8_ch);

        b1_n = (EditText)findViewById(R.id.edit_b1_n);
        b2_n = (EditText)findViewById(R.id.edit_b2_n);
        b3_n = (EditText)findViewById(R.id.edit_b3_n);
        b4_n = (EditText)findViewById(R.id.edit_b4_n);
        b5_n = (EditText)findViewById(R.id.edit_b5_n);
        b6_n = (EditText)findViewById(R.id.edit_b6_n);
        b7_n = (EditText)findViewById(R.id.edit_b7_n);
        b8_n = (EditText)findViewById(R.id.edit_b8_n);

        b_save = (Button)findViewById(R.id.b_save);

        GetButtonData();

        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fatch_Information();
                SaveData();
            }
        });
    }

    private void GetButtonData()
    {
        SharedPreferences sharedPreferences = Configuration_Panel.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);
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

        b1_n.setText(b1_name);
        b2_n.setText(b2_name);
        b3_n.setText(b3_name);
        b4_n.setText(b4_name);
        b5_n.setText(b5_name);
        b6_n.setText(b6_name);
        b7_n.setText(b7_name);
        b8_n.setText(b8_name);

        b1_ch.setText(b1);
        b2_ch.setText(b2);
        b3_ch.setText(b3);
        b4_ch.setText(b4);
        b5_ch.setText(b5);
        b6_ch.setText(b6);
        b7_ch.setText(b7);
        b8_ch.setText(b8);
    }

    public void Fatch_Information()
    {
        b1 = b1_ch.getText().toString();
        b2 = b2_ch.getText().toString();
        b3 = b3_ch.getText().toString();
        b4 = b4_ch.getText().toString();
        b5 = b5_ch.getText().toString();
        b6 = b6_ch.getText().toString();
        b7 = b7_ch.getText().toString();
        b8 = b8_ch.getText().toString();

        b1_name = b1_n.getText().toString();
        b2_name = b2_n.getText().toString();
        b3_name = b3_n.getText().toString();
        b4_name = b4_n.getText().toString();
        b5_name = b5_n.getText().toString();
        b6_name = b6_n.getText().toString();
        b7_name = b7_n.getText().toString();
        b8_name = b8_n.getText().toString();
    }

    public void SaveData()
    {

        SharedPreferences sharedPreferences = Configuration_Panel.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.BUTTON_1), b1);
        editor.putString(getString(R.string.BUTTON_2), b2);
        editor.putString(getString(R.string.BUTTON_3), b3);
        editor.putString(getString(R.string.BUTTON_4), b4);
        editor.putString(getString(R.string.BUTTON_5), b5);
        editor.putString(getString(R.string.BUTTON_6), b6);
        editor.putString(getString(R.string.BUTTON_7), b7);
        editor.putString(getString(R.string.BUTTON_8), b8);

        editor.putString(getString(R.string.BUTTON_1_Name), b1_name);
        editor.putString(getString(R.string.BUTTON_2_Name), b2_name);
        editor.putString(getString(R.string.BUTTON_3_Name), b3_name);
        editor.putString(getString(R.string.BUTTON_4_Name), b4_name);
        editor.putString(getString(R.string.BUTTON_5_Name), b5_name);
        editor.putString(getString(R.string.BUTTON_6_Name), b6_name);
        editor.putString(getString(R.string.BUTTON_7_Name), b7_name);
        editor.putString(getString(R.string.BUTTON_8_Name), b8_name);
        editor.commit();


    }
}
