package com.example.exaales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExamAle extends AppCompatActivity {
    Button btnAgregar;
    Button btnLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_ale);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnLista = findViewById(R.id.btnLista);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamAle.this, AgregarContacto.class);
            }
        });
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamAle.this, ListaContacto.class);
                startActivity(intent);
            }
        });
    }
}


/**public void activityAgregarContacto(View view){
 Intent intent = new Intent(this,AgregarContacto .class);
 startActivity(intent);
 }
 public void activityVerLista(View view) {
 Intent intent = new Intent(this, ListaContacos.class);
 startActivity(intent);
 };*/