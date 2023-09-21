package com.example.examen_notas_todo.ui.home;
import android.app.Application;
import android.content.Context;

import com.example.examen_notas_todo.MainActivity;
import com.example.examen_notas_todo.modelo.Nota;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private Context context;

    private MutableLiveData<List<Nota>> mLista;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<List<Nota>> getmLista() {
        if(mLista == null){
            mLista = new MutableLiveData<>();
        }
        return mLista;
    }

    public void setLista(){
        mLista.setValue(MainActivity.Notas);
    }
}