package com.example.unit_10;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity01 extends AppCompatActivity {

    EditText name;
    EditText last_name;

    Button save;
    Button recuperate;

    TextView result_name;
    TextView result_last_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);

        name = (EditText) findViewById(R.id.name);
        last_name = (EditText) findViewById(R.id.last_name);

        save = (Button) findViewById(R.id.save);
        recuperate = (Button) findViewById(R.id.recuperate);

        result_name = (TextView) findViewById(R.id.result_name);
        result_last_name = (TextView) findViewById(R.id.result_lastname);

        //SharedPreferences preferences=getPreferences(Context.MODE_PRIVATE);
        SharedPreferences preferences = getSharedPreferences("preferencias01", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SharedPreferences.Editor editor=preferences.edit();
                editor.putString("name", String.valueOf(name.getText()));
                editor.putString("last_name", String.valueOf(last_name.getText()));
                editor.commit();
            }
        });

        recuperate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nb = preferences.getString("name", "nombre...");
                String apll = preferences.getString("last_name", "apellidos...");

                result_name.setText(nb);
                result_last_name.setText(apll);
            }
        });

    }
}