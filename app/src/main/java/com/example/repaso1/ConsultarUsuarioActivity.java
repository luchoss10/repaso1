package com.example.repaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.PrecomputedText;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.repaso1.utilidades.Utilidades;

public class ConsultarUsuarioActivity extends AppCompatActivity {

    EditText id, nombre, telefono;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);
        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_usuarios", null, 1);
        id = findViewById(R.id.id_usuarioC);
        nombre = findViewById(R.id.nombre_usuarioC);
        telefono = findViewById(R.id.telefono_usuarioC);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buscarUsuario:
                buscarUsuario();
                break;
            case R.id.actualizarUsuario:
                actualizarUsuario();
                break;
            case R.id.eliminarUsuario:
                eliminarUsuario();
                break;
        }
    }

    private void eliminarUsuario() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] params = {id.getText().toString()};
        db.delete(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID+"=?", params);
        Toast.makeText(getApplicationContext(), "Usuario Eliminado", Toast.LENGTH_LONG).show();
        db.close();
    }

    private void actualizarUsuario() {

        String[] params = {id.getText().toString()};
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE, nombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, telefono.getText().toString());
        db.update(Utilidades.TABLA_USUARIO, values, Utilidades.CAMPO_ID + "=?", params);
        Toast.makeText(getApplicationContext(), "Actualizacion Realizada", Toast.LENGTH_LONG).show();
        db.close();
    }

    public void buscarUsuario() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] params = {id.getText().toString()};
        String[] camposV = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_TELEFONO};
        try {
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, camposV, Utilidades.CAMPO_ID + "=?", params, null, null, null);
            cursor.moveToFirst();
            nombre.setText(cursor.getString(0));
            telefono.setText(cursor.getString(1));
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "El documento no existe", Toast.LENGTH_LONG).show();
            limpiar();
        }
        db.close();
    }

    private void limpiar() {
        nombre.setText("");
        telefono.setText("");
    }
}