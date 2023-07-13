package com.example.practica8;

import static androidx.core.app.NotificationCompat.getExtras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION = 1001;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_VIEW_IMAGE_CAPTURE = 2;
    private ImageView imagen1;
    public String fileName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen1 = findViewById(R.id.imageView);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        fileName = preferences.getString("path", "");
        Bitmap bitmap = BitmapFactory.decodeFile(getExternalFilesDir(null) + "/" + fileName);
        imagen1.setImageBitmap(bitmap);
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

            Intent intent = new Intent(this, VisorFotos.class);
            startActivityForResult(intent, REQUEST_VIEW_IMAGE_CAPTURE);
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
            this.tomarFoto();
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION);
            } else {
                this.tomarFoto();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            //Se cerro la camara
            Bitmap bitmap = BitmapFactory.decodeFile(getExternalFilesDir(null) + "/" + fileName);
            imagen1.setImageBitmap(bitmap);

            SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("path", fileName);
            editor.commit();
        } else if(requestCode == REQUEST_VIEW_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            if(extras != null){
                String value = extras.getString("path");
                Bitmap bitmap = BitmapFactory.decodeFile(getExternalFilesDir(null) + "/" + value);
                imagen1.setImageBitmap(bitmap);
            }
        }
    }

    public void tomarFoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        fileName = mDateFormat.format(new Date()) + ".jpg";

        File foto = new File(getExternalFilesDir(null), fileName);
        Uri photoUri = FileProvider.getUriForFile(this,"com.example.practica8.fileprovider", foto);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }
}