package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

public class spinner extends AppCompatActivity {
    private Spinner Spinner1;
    private EditText TxtNum1, TxtNum2;
    private TextView TxtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        Spinner1 = findViewById(R.id.spinner);
        TxtNum1 = findViewById(R.id.TxtSpinnerNum1);
        TxtNum2 = findViewById(R.id.TxtSpinnerNum2);
        TxtResult = findViewById(R.id.TxtSpinnerResult);

        String[]Opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Opciones);
        Spinner1.setAdapter(adapter);
    }

    public void calcular(View view){
        String valor1 = TxtNum1.getText().toString();
        String valor2 = TxtNum2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);

        String select = Spinner1.getSelectedItem().toString();

        if(select.equals("Sumar")){
            int suma = num1 + num2;
            String resultado = String.valueOf(suma);
            TxtResult.setText(resultado);
        }else if(select.equals("Restar")){
            int suma = num1 - num2;
            String resultado = String.valueOf(suma);
            TxtResult.setText(resultado);
        }else if(select.equals("Multiplicar")){
            int suma = num1 * num2;
            String resultado = String.valueOf(suma);
            TxtResult.setText(resultado);
        } else if (select.equals("Dividir")) {
            int suma = num1 / num2;

            String resultado = String.valueOf(suma);
            TxtResult.setText(resultado);
        }
    }
}