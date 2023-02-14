package com.example.unit_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity02 extends AppCompatActivity {

    EditText description;
    Button save;
    Button recuperate;

    TextView result_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);

        description=(EditText) findViewById(R.id.description);

        save=(Button) findViewById(R.id.saveFile);
        recuperate=(Button) findViewById(R.id.recuperateFile);

        result_description=(TextView) findViewById(R.id.result_description);

        SharedPreferences preferences=getSharedPreferences("preferencias02", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OutputStreamWriter myFile=new OutputStreamWriter(openFileOutput("fichero.txt",Context.MODE_PRIVATE));
                    myFile.write(String.valueOf(description.getText()));
                    myFile.close();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        });

        recuperate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BufferedReader myFile=new BufferedReader(new InputStreamReader(openFileInput("fichero.txt")));
                    String text=myFile.readLine();
                    myFile.close();
                    result_description.setText(text);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });

    }
}