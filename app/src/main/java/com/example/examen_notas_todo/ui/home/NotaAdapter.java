package com.example.examen_notas_todo.ui.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_notas_todo.R;
import com.example.examen_notas_todo.modelo.Nota;

import java.util.List;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {
    private final Context context;
    private final List<String> notas;
    private final LayoutInflater layoutInflater;

    public NotaAdapter(Context context, List<String> notas, LayoutInflater layoutInflater) {
        this.context = context;
        this.notas = notas;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=layoutInflater.inflate(R.layout.nota,parent,false);
        return new  ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo.setText(notas.get(position));
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        Button btnContenido;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.tvTitulo);
            btnContenido=itemView.findViewById(R.id.btnContenido);

            btnContenido.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("notas", notas.get(getAdapterPosition()));
                    bundle.putSerializable("index",getAdapterPosition());

                    Navigation.findNavController( (Activity)context,R.id.nav_host_fragment_content_main).navigate(R.id.action_nav_to_contenido,bundle);
                }
            });
        }
    }
}
