package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText TxtURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TxtURL = findViewById(R.id.TxtURL);
    }

    public void ver(View view){
        Intent intent = new Intent(this, Visor.class);
        intent.putExtra("url", TxtURL.getText().toString());
        startActivity(intent);
    }
}