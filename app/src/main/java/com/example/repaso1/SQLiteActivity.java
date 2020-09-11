package com.example.repaso1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SQLiteActivity extends AppCompatActivity {

    //POJO --> clase plana de java.
    //Contiene los atributos que referencian a la estructura de la tabla creada en la DB.

    Button registrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        registrarUsuario = findViewById(R.id.registro);
        registrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrarUsuarioSQLitleActivity.class);
                startActivity(intent);
            }
        });
    }
}
