package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SeleccionActividades extends AppCompatActivity {

    private Button Act1, Act2, Act3, Act4, Act5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_actividades);
        Act1 = findViewById(R.id.Practica1);
        Act2 = findViewById(R.id.Practica2);
        Act3 = findViewById(R.id.Practica3);
        Act4 = findViewById(R.id.Practica4);
        Act5 = findViewById(R.id.Practica5);
    }

    public void VerificarBoton(View view) {
        if (Act1.isPressed() == true) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (Act2.isPressed() == true) {
            Intent intent = new Intent(this, Radio.class);
            startActivity(intent);
        } else if (Act3.isPressed() == true) {
            Intent intent = new Intent(this, spinner.class);
            startActivity(intent);
        } else if (Act4.isPressed() == true) {
            Intent intent = new Intent(this, Listas.class);
            startActivity(intent);
        } else if (Act5.isPressed() == true) {
        Intent intent = new Intent(this, toast.class);
        startActivity(intent);
        }
    }
}