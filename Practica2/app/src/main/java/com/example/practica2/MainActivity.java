package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText Txtnum1;
    private EditText Txtnum2;
    private TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Txtnum1 = findViewById(R.id.Num1);
        Txtnum2 = findViewById(R.id.Num2);
        Result = findViewById(R.id.Result);
    }

    public void sumar(View view){
        String valor1 = Txtnum1.getText().toString();
        String valor2 = Txtnum2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);

        int suma = num1 + num2;

        String s = Integer.toString(suma);

        Result.setText(s);
    }

    public void cambiarActividad( View view){
        Intent intent = new Intent(this,Radio.class);
        startActivity(intent);
    }
}