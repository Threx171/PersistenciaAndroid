package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        EditText surName = findViewById(R.id.surname);
        EditText phone = findViewById(R.id.phone);
        EditText mail = findViewById(R.id.email);
        Button save = findViewById(R.id.button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream os;
                String fileText = "";
                fileText += name.getText() + ";";
                fileText += surName.getText() + ";";
                fileText += phone.getText() + ";";
                fileText += mail.getText() + ";";

                try {
                    os = openFileOutput("contactes.txt", Context.MODE_PRIVATE);
                    os.write(fileText.getBytes());
                    os.close();
                    Toast toast = Toast.makeText(getApplicationContext(), "Contact successfully saved",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }catch (Exception e) {
                    Log.i("INFO", "Error saving file");
                    Toast toast = Toast.makeText(getApplicationContext(), "Error saving file",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}