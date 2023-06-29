package com.example.practica7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LinearActivity(View view){
        Intent intent = new Intent(this, LinearLayout.class);
        startActivity(intent);
    }

    public void TableLayout(View view){
        Intent intent = new Intent(this, TableLayout.class);
        startActivity(intent);
    }

    public void FrameLayout(View view){
        Intent intent = new Intent(this, FramrLayout.class);
        startActivity(intent);
    }

    public void ScrollLayout(View view){
        Intent intent = new Intent(this, ScrollView.class);
        startActivity(intent);
    }
}