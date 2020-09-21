package com.example.repaso1.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.repaso1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_checkbox:
                Intent intent = new Intent(getApplicationContext(), CheckBoxActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_ConsultarSQLitle:
                Intent intent1 = new Intent(getApplicationContext(), SQLiteActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_RegistrarSQLitle:
                Intent intent2 = new Intent(getApplicationContext(), RegistrarUsuarioSQLitleActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_SharedPreferences:
                Intent intent3 = new Intent(getApplicationContext(), sharedExampleActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_Fragments:
                Intent intent4 = new Intent(getApplicationContext(), FragmentsActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_ButterKnifeActivity:
                Intent intent5 = new Intent(getApplicationContext(), ViewBActivity.class);
                startActivity(intent5);
                break;

        }
    }
}
