package com.example.examen_notas_todo.ui.home;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.examen_notas_todo.MainActivity;
import com.example.examen_notas_todo.modelo.Nota;

public class ContenidoViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Nota> lista;
    private MutableLiveData<Integer> index;
    private Nota nota ;

    public ContenidoViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Nota> getNota() {
        if(this.lista == null){
            this.lista = new MutableLiveData<>();
        }
        return this.lista;
    }

    public LiveData<Integer> getIndex() {
        if(this.index == null){
            this.index = new MutableLiveData<>();
        }
        return this.index;
    }

    public void llenarNota(Bundle bundle){
        String  resultado = bundle.getString("nota");
        lista.setValue(nota);
    }

    public void borrarNota(int index){
        this.index.setValue(index);
        MainActivity.Notas.remove(index);
    }

}