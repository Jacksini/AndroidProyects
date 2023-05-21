package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Radio extends AppCompatActivity {

    private EditText Txtnum1;
    private EditText Txtnum2;
    private TextView TxtResult;
    private RadioButton radioSuma, radioResta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        Txtnum1 = findViewById(R.id.TxtRadio1);
        Txtnum2 = findViewById(R.id.TxtRadio2);
        TxtResult = findViewById(R.id.TxtResultado);
        radioResta = findViewById(R.id.radioResta);
        radioSuma = findViewById(R.id.radioSuma);
    }

    public void calcular(View view){
        String valor1 = Txtnum1.getText().toString();
        String valor2 = Txtnum2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);

        if(radioSuma.isChecked() == true){
            int suma = num1 + num2;
            String s = String.valueOf(suma);
            TxtResult.setText(s);
        }else if(radioResta.isChecked()){
            int resta = num1 - num2;
            String s = String.valueOf(resta);
            TxtResult.setText(s);
        }
    }
}