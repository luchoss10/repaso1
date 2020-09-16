package com.example.repaso1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.repaso1.Fragments.FragmentAzul;
import com.example.repaso1.Fragments.FragmentRojo;
import com.example.repaso1.Fragments.FragmentVerde;

public class FragmentsActivity extends AppCompatActivity {

    Fragment fragmentRojo, fragmentAzul, fragmentVerde;
    FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        fragmentRojo = new FragmentRojo();
        fragmentAzul = new FragmentAzul();
        fragmentVerde = new FragmentVerde();

        getSupportFragmentManager().beginTransaction().add(R.id.frame_fragmnts, fragmentRojo).commit();
    }

    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.btn_rojo:
                transaction.replace(R.id.frame_fragmnts, fragmentRojo);
                transaction.addToBackStack(null);
                break;
            case R.id.btn_azul:
                transaction.replace(R.id.frame_fragmnts, fragmentAzul);
                transaction.addToBackStack(null);
                break;
            case R.id.btn_verde:
                transaction.replace(R.id.frame_fragmnts, fragmentVerde);
                transaction.addToBackStack(null);
                break;
        }

        transaction.commit();
    }
}