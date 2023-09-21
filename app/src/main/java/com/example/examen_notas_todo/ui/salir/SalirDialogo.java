package com.example.examen_notas_todo.ui.salir;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;

import com.example.examen_notas_todo.MainActivity;


public class SalirDialogo {

    public static void Salir (Activity activity){
        new AlertDialog.Builder(activity)
                .setTitle("Salir")
                .setMessage("¿Salir de la aplicación?")
                .setPositiveButton("Si", (dialogInterface, i) -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activity.finishAndRemoveTask();
                    } else {
                        activity.finishAffinity();
                    }
                    System.exit(0);
                })
                .setNegativeButton("No", (dialogInterface, i) -> {
                    Intent intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                })
                .show();
    }
//    public static void Salir (Activity activity){
//        new AlertDialog.Builder(activity)
//                .setTitle("Salir")
//                .setMessage("¿Salir de la aplicación?")
//                .setPositiveButton("Si", (dialogInterface, i) -> System.exit(0))
//                .setNegativeButton("No", (dialogInterface, i) -> {
//                    Intent intent = new Intent(activity, MainActivity.class);
//                    activity.startActivity(intent);
//                })
//                .show();
//    }
}