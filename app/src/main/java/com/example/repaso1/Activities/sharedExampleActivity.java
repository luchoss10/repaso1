package com.example.repaso1.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.repaso1.R;

public class sharedExampleActivity extends AppCompatActivity {

    EditText datUs, datCon;
    TextView txtUsuario, txtContra;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_example);

        datUs = findViewById(R.id.campo_usuario);
        datCon = findViewById(R.id.campo_contra);
        txtUsuario = findViewById(R.id.datos_usuario);
        txtContra = findViewById(R.id.datos_contra);
        btnGuardar = findViewById(R.id.guardar);

        cargarPreferencias();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(v);
            }
        });
    }



    public void guardar(View view){
        guardarPreferencias();
    }

    private void cargarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String user = preferences.getString("user", "No exite la ibnformacion");
        String pass = preferences.getString("pass", "No exite la ibnformacion");

        txtUsuario.setText(user);
        txtContra.setText(pass);
    }

    private void guardarPreferencias() {
        SharedPreferences preferences =  getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String usuario = datUs.getText().toString();
        String contraseña=datCon.getText().toString();

        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("user", usuario);
        editor.putString("pass", contraseña);

        editor.commit();
    }


}
