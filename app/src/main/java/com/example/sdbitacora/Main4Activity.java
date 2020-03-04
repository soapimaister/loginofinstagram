package com.example.sdbitacora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main4Activity extends AppCompatActivity {

    private EditText edt1, edt2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        edt1 = (EditText) findViewById(R.id.edt1a4);
        b1 = (Button) findViewById(R.id.b4);
        b1.setEnabled(false);
        edt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nombre = edt1.getText().toString();
                if (nombre.length() < 1) {
                    b1.setEnabled(false);
                } else if (nombre.length() > 1) {
                    b1.setEnabled(true);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void siguiente(View view) {
        String user = edt1.getText().toString();
        SharedPreferences pref1 = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor objeditor = pref1.edit();
        objeditor.putString("user", user);
        objeditor.commit();
        String a = pref1.getString("user", Context.ACCESSIBILITY_SERVICE);
        Intent llevarnombre = new Intent(this, Main5Activity.class);
        llevarnombre.putExtra("user", pref1.getString("user", a));
        startActivity(llevarnombre);
        overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);


    }

    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new  AlertDialog.Builder(Main4Activity.this,AlertDialog.THEME_HOLO_LIGHT);
        alerta.setMessage("¿Seguro que quiere cancelar el registro?");
        alerta.setPositiveButton("Seguro", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                edt1.setText("");



            }
        });
        alerta.setNegativeButton("No, continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alerta.setCancelable(true);
        alerta.create().show();

    }
}