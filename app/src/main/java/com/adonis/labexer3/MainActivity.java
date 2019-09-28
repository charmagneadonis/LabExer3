package com.adonis.labexer3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText input1, input2, input3, input4, input5, input6, input7, input8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.editText2);
        input2 = findViewById(R.id.editText3);
        input3 = findViewById(R.id.editText4);
        input4 = findViewById(R.id.editText5);
        input5 = findViewById(R.id.editText6);
        input6 = findViewById(R.id.editText7);
        input7 = findViewById(R.id.editText8);
        input8 = findViewById(R.id.editText9);
    }

    public void NextPage (View v) {
        Intent i = new Intent (this, SecondPage.class);
        startActivity(i);
    }

    public void writeData (View v) {
        String data1 =  input1.getText().toString();
        String data2 =  input2.getText().toString();
        String data3 =  input3.getText().toString();
        String data4 =  input4.getText().toString();
        String data5 =  input5.getText().toString();
        String data6 =  input6.getText().toString();
        String data7 =  input7.getText().toString();
        String data8 =  input8.getText().toString();
        String alldata = "";

        alldata = data1 + "," + data2 + "," + data3 + "," + data4 + "," + data5 + "," + data6  + "," + data7  + "," +data8;

        

        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(alldata.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("error", "File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("error", "IO Error");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("error", "File Not Found");
            }
        }

        Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show();
    }
}
