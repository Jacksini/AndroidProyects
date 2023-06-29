package com.example.practica8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA_PERMISSION = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.opcion1){
            Toast.makeText(this, "Selecciono la opcion 1", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.opcion2){
            Toast.makeText(this, "Selecciono la opcion 2", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.opcion3){
            Toast.makeText(this, "Selecciono la opcion 3", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.Telefono){
            Toast.makeText(this, "Selecciono el telefono", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.Camara){
            Toast.makeText(this, "Selecciono la Camara", Toast.LENGTH_SHORT).show();
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
            } else {
                this.tomarFoto();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public void tomarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File foto = new File(getExternalFilesDir(null), "foto1.jpg");
        Uri photoUri = FileProvider.getUriForFile(this,"com.example.practica8.fileprovider", foto);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        startActivity(intent);
    }
}