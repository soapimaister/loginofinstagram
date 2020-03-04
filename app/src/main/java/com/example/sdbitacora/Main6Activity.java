package com.example.sdbitacora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);




    }

    @Override
    public void finish() {
        super.finish();

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder Alerta = new AlertDialog.Builder(this,AlertDialog.THEME_HOLO_LIGHT);
        Alerta.setMessage("¿Desea salir de instagram?");
        Alerta.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

               moveTaskToBack(true);

            }
        });
        Alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        Alerta.setCancelable(true);
        Alerta.create().show();


    }
}
