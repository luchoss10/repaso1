package com.example.repaso1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.repaso1.Fragments.FragmentViewB;
import com.example.repaso1.databinding.ActivityViewBBinding;

public class ViewBActivity extends AppCompatActivity {

    private Fragment fragment_ViewB;
    //Se crea la clase asociada al activity layout NombreActivityBiding
    private ActivityViewBBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Se Obtiene el layout inflado con el metodo inflate de la clase Binding.
        binding = ActivityViewBBinding.inflate(getLayoutInflater());

        fragment_ViewB = new FragmentViewB();

        binding.buttonViewBActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = binding.editTextViewBActivity.getText().toString();
                if (!texto.equals(""))
                    binding.textViewViewBActivity.setText(texto);
                else
                    Toast.makeText(getApplicationContext(), "Ingresa Algo porfis", Toast.LENGTH_LONG).show();
            }
        });

        //Se obtiene la vista por medio del metodo getRoot de la clase Binding.
        View view = binding.getRoot();
        //Se retorna al Contentiew el view.
        setContentView(view);

        getSupportFragmentManager().beginTransaction().add(binding.frameViewBFragment.getId(), fragment_ViewB).commit();

    }
}