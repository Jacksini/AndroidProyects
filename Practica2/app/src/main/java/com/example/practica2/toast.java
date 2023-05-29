package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class toast extends AppCompatActivity {

    private EditText TxtToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        TxtToast = findViewById(R.id.TxtToast);
    }

    public void MostrarToast(View view){
        String texto = TxtToast.getText().toString();
        Toast notification = Toast.makeText(this, texto, Toast.LENGTH_SHORT);
        notification.show();
    }
}