package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText TxtCodigo, TxtDescripcion, TxtPrecio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TxtCodigo = findViewById(R.id.TxtCodigo);
        TxtDescripcion = findViewById(R.id.TxtNombre);
        TxtPrecio = findViewById(R.id.Precio);
    }
    public void agregar(View view) {
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this,"tienda",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("codigo", TxtCodigo.getText().toString());
        registro.put("descripcion", TxtDescripcion.getText().toString());
        registro.put("precio", TxtPrecio.getText().toString());
        db.insert("articulos",null,registro);
        db.close();

        TxtDescripcion.setText("");
        TxtPrecio.setText("");
        TxtCodigo.setText("");

        Toast.makeText(this,"Articulo agregado con exito", Toast.LENGTH_SHORT).show();
    }
    public void mostrarPorCodigo(View view) {
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this,"tienda",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = TxtCodigo.getText().toString();
        Cursor fila = db.rawQuery("select descripcion, precio from articulos where codigo = " + codigo, null);

        if (fila.moveToFirst()){
            TxtDescripcion.setText(fila.getString(0));
            TxtPrecio.setText(fila.getString(1));
        }else{
            Toast.makeText(this,"No existe un articulo con ese codigo", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }
    public void modificar(View view){
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this,"tienda",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("codigo", TxtCodigo.getText().toString());
        registro.put("descripcion", TxtDescripcion.getText().toString());
        registro.put("precio", TxtPrecio.getText().toString());
        int cantidad = db.update("articulos", registro, "codigo = " + TxtCodigo.getText().toString(), null);
        db.close();

        if(cantidad == 1){
            Toast.makeText(this,"Articulos actualizados", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"No existe un articulo con ese codigo", Toast.LENGTH_SHORT).show();
        }
    }
    public void eliminar(View view) {
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this,"tienda",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = TxtCodigo.getText().toString();
        int cantidad = db.delete("articulos","codigo = " + codigo, null);
        db.close();
        TxtDescripcion.setText("");
        TxtPrecio.setText("");
        TxtCodigo.setText("");
        if(cantidad == 1){
            Toast.makeText(this,"El articulo fue eliminado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"No existe un articulo con ese codigo", Toast.LENGTH_SHORT).show();
        }
    }
}