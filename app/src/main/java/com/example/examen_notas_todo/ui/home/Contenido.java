package com.example.examen_notas_todo.ui.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.examen_notas_todo.databinding.FragmentContenidoBinding;
import com.example.examen_notas_todo.modelo.Nota;

public class Contenido extends Fragment{
    private ContenidoViewModel mViewModel;
    private FragmentContenidoBinding binding;
    private int index;

    public static Contenido newInstance() {
        return new Contenido();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {ContenidoViewModel mv =
            new ViewModelProvider(this).get(ContenidoViewModel.class);

        binding = FragmentContenidoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv.getIndex().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.d("salida", "borrada: "+integer);
                Toast.makeText(getContext(),"Nota N° "+(index+1)+" eliminada", Toast.LENGTH_LONG).show();
            }
        });

        mv.getNota().observe(getViewLifecycleOwner(), new Observer<Nota>() {
            @Override
            public void onChanged(Nota a) {
                binding.tvTitulo.setText(a.getTitulo()+"");
                binding.tvContenido.setText(a.getContenido()+"");
            }
        });


        binding.btEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.borrarNota(index);
//                mv.eliminarElemento(binding.tvNota.getText().toString());
//                Navigation.findNavController(view).navigate(R.id.nav_home, null);
            }
        });
        mv.llenarNota(getArguments());
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ContenidoViewModel.class);
        // TODO: Use the ViewModel
    }


}
