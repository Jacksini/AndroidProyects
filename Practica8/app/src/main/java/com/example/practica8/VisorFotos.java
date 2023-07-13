package com.example.practica8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;

public class VisorFotos extends AppCompatActivity {
    private ListView mListView;
    private ImageView mImageView;
    private String[] fotos;
    private ArrayAdapter<String> adaptadorArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_fotos);

        File dir = getExternalFilesDir(null);
        fotos = dir.list();
        adaptadorArray = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fotos);
        mListView = (ListView)findViewById(R.id.ListaFotos);
        mListView.setAdapter(adaptadorArray);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent result = new Intent();
                result.putExtra("path", fotos[position]);
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }


}