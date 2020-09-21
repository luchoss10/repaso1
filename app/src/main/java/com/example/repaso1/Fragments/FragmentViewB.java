package com.example.repaso1.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.repaso1.R;
import com.example.repaso1.databinding.FragmentViewBBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentViewB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentViewB extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentViewBBinding binding;

    public FragmentViewB() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ButterKnifeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentViewB newInstance(String param1, String param2) {
        FragmentViewB fragment = new FragmentViewB();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Se infla la vista con el metodo provisto por la clase Biding del layout, asociado.
        binding = FragmentViewBBinding.inflate(inflater, container, false);
        //return inflater.inflate(R.layout.fragment_view_b, container, false);

        //De la misma manera que en el activity
        binding.buttonViewBFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = binding.editTextViewBFragment.getText().toString();
                if (!texto.equals(""))
                    binding.textViewViewBFragment.setText(texto);
                else
                    Toast.makeText(getContext(), "Ingresa Algo porfis, en el fragment ;)", Toast.LENGTH_LONG).show();
            }
        });

        //Se obtiene la vista por medio del metodo getRoot de la clase Binding
        View view = binding.getRoot();
        //Se retorna para inflar respectivamente en el activiity.
        return view;
    }

    //Asegurarce que cuando la vista se desinfle o destruya, se elimine la instancia del objeto de la clase Binding
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}