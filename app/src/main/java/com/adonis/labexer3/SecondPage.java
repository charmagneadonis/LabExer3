package com.adonis.labexer3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondPage extends AppCompatActivity {
    String data = "";
    String[] dataarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        FileInputStream reader = null;

        try {
            reader = openFileInput("data1.txt");
            int token;
            while ((token = reader.read()) != -1) {
                data = data + (char)token;
            }

            dataarray = data.split(",");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("error", "IO Error");
        }

    }

    public void ConfirmData (View v) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }

}
