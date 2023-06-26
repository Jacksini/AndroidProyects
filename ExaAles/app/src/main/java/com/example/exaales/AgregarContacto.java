package com.example.exaales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarContacto extends AppCompatActivity {

    EditText txtNombre;
    EditText txtNumero;
    EditText txtDireccion;
    Button btnGuardar;
    Button btnEliminar;
    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

        txtNombre = findViewById(R.id.txtNombre);
        txtNumero = findViewById(R.id.txtNumero);
        txtDireccion = findViewById(R.id.txtDireccion);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnSalir = findViewById(R.id.btnSalir);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes guardar la información en la base de datos
                String nombre = txtNombre.getText().toString();
                String telefono = txtNumero.getText().toString();
                String direccion = txtDireccion.getText().toString();

                // Código para guardar en la base de datos

                Toast.makeText(AgregarContacto.this, "Contacto guardado exitosamente", Toast.LENGTH_SHORT).show();
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes implementar la lógica para eliminar el contacto seleccionado
                Toast.makeText(AgregarContacto.this, "Contacto eliminado con exito", Toast.LENGTH_SHORT).show();
            }
        });
        //Salir
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }}