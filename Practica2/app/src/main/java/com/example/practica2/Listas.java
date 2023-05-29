package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Listas extends AppCompatActivity {

    private String[] carreras = {"Biotecnologia", "Informatica", "Mecatronica", "Animacion", "Terapia fisica", "Administracion", "Nanotecnologia", "Energia"};
    private String[] almunos = {"200", "20", "360", "100", "115", "90", "55", "69"};
    private TextView Txt1;
    private ListView List1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);
        List1 = findViewById(R.id.List1);
        Txt1 = findViewById(R.id.Txt1);
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, carreras);
        List1.setAdapter(adapter);

        List1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Txt1.setText("La carrera de: " + List1.getItemAtPosition(position) + " tiene " + almunos[position] + " alumnos");
            }
        });
    }

}