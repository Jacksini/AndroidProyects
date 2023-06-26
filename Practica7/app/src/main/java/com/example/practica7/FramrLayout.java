package com.example.practica7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FramrLayout extends AppCompatActivity {

    private ImageView Img1;
    private Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framr_layout);

        Img1 = findViewById(R.id.ImgAv);
        boton1 = findViewById(R.id.BtnLlamar);
    }

    public void Ocultar(View view) {
        boton1.setVisibility(View.INVISIBLE);
        Img1.setVisibility(View.VISIBLE);
    }
}