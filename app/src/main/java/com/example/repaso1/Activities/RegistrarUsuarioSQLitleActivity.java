package com.example.repaso1.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.repaso1.ConexionSQLiteHelper;
import com.example.repaso1.R;
import com.example.repaso1.utilidades.Utilidades;

public class RegistrarUsuarioSQLitleActivity extends AppCompatActivity {

    EditText campoId, campoNombre, campoTelefono;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario_sqlitle);

        campoId = findViewById(R.id.id);
        campoNombre = findViewById(R.id.nombre);
        campoTelefono = findViewById(R.id.telefono);
        btnRegistrar = findViewById(R.id.registrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuarios();
            }
        });

    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "db_usuarios", null, 1);

        //Abrir base de datos para poder editarla
        SQLiteDatabase db = conexion.getWritableDatabase();

        //Android nos da la forma de realizar el registro por medio de ContentValues
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID, campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, campoTelefono.getText().toString());

        //Ahora insertar todos los valores a la DB.
        //Vamos  a usar el metodo insert de nuestro SQLiteDatabase el cual nos
        // retorna un long dependiendo de los datos que le enviemos.

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);

        Toast.makeText(getApplicationContext(), "Id Registro "+ idResultante, Toast.LENGTH_LONG).show();
        db.close();
    }
}
