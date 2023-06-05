package com.example.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Visor extends AppCompatActivity {

    private WebView web1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);

        web1 = findViewById(R.id.webView);

        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        web1.loadUrl("https://" + url);
    }

    public void finalizar(View view){
        finish();
    }
}