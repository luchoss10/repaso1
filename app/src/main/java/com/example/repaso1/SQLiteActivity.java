package com.example.repaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SQLiteActivity extends AppCompatActivity {

    //POJO --> clase plana de java.
    //Contiene los atributos que referencian a la estructura de la tabla creada en la DB.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        ConexionSQLiteHelper conexion =new ConexionSQLiteHelper(this, "db.usuarios", null, 1);
    }
}
