package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText TxtUser;
    private EditText TxtPassword;
    private String User = "Upsin";
    private String Password = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TxtUser =findViewById(R.id.TxtUsuario);
        TxtPassword =findViewById(R.id.TxtPass);
    }

    public void Verificar(View view){
        String Usuario = TxtUser.getText().toString();
        String Pass = TxtPassword.getText().toString();

        if(User.equals(Usuario) && Password.equals(Pass)){
            cambiarActividad();
        } else if(User.equals(Usuario) == false && Password.equals(Pass)){
            Toast notification = Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT);
            notification.show();
        } else if(User.equals(Usuario) && Password.equals(Pass) == false){
            Toast notification = Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT);
            notification.show();
        } else if(User.equals(Usuario) == false && Password.equals(Pass) == false){
            Toast notification = Toast.makeText(this, "Usuario y conctraseña incorrecctos", Toast.LENGTH_SHORT);
            notification.show();
        } else if (Usuario.isEmpty()){
            Toast notification = Toast.makeText(this, "Usuario no ingresado", Toast.LENGTH_SHORT);
            notification.show();
        } else if(Pass.isEmpty()){
            Toast notification = Toast.makeText(this, "Contraseña no ingresada", Toast.LENGTH_SHORT);
            notification.show();
        }
    }

    public void cambiarActividad(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}