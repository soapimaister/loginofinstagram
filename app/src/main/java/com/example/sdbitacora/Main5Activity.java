package com.example.sdbitacora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main5Activity extends AppCompatActivity {
    private EditText edt1,edt2;
    private Button b1;
    private ImageView visto1pass1,x1pass1,visto2pass2,x2pass2;
    private ImageButton ver,nover;
    private TextView tv1,tv2registrocorrecto,tv3contraseñasincorrectas,tv9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        edt1 = (EditText)findViewById(R.id.edtpass1);
        edt2 = (EditText)findViewById(R.id.edtpass2);
        visto1pass1 = (ImageView)findViewById(R.id.v1pass1);
        x1pass1 = (ImageView)findViewById(R.id.x2pass1);
        visto2pass2 = (ImageView)findViewById(R.id.v2pass2);
        x2pass2 = (ImageView)findViewById(R.id.x1pass2);
        ver = (ImageButton)findViewById(R.id.ver);
        nover = (ImageButton)findViewById(R.id.nover);
        b1 = (Button)findViewById(R.id.b1registro);
        tv1 = (TextView)findViewById(R.id.textView5);
        tv2registrocorrecto = (TextView) findViewById(R.id.tvregistrocompleto);
        tv3contraseñasincorrectas = (TextView)findViewById(R.id.tvcontraseñasincor);
        tv9 = (TextView)findViewById(R.id.tv9);

        ver.setVisibility(View.INVISIBLE);
        visto1pass1.setVisibility(View.INVISIBLE);
        x1pass1.setVisibility(View.INVISIBLE);
        visto2pass2.setVisibility(View.INVISIBLE);
        x2pass2.setVisibility(View.INVISIBLE);
        tv2registrocorrecto.setVisibility(View.INVISIBLE);
        tv3contraseñasincorrectas.setVisibility(View.INVISIBLE);



        b1.setEnabled(false);
        String tener = getIntent().getStringExtra("user");
        tv9.setText(tener);


        edt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String tenerpass2 = edt2.getText().toString();
                String tenerpass1 = edt1.getText().toString();
                if(tenerpass2.equals(tenerpass1)){
                    visto2pass2.setVisibility(View.VISIBLE);
                    x2pass2.setVisibility(View.INVISIBLE);
                }else if(tenerpass2.equals(tenerpass1) == false){
                    x2pass2.setVisibility(View.VISIBLE);
                    visto2pass2.setVisibility(View.INVISIBLE);
                }
                if(tenerpass2.length() == 0){
                    x2pass2.setVisibility(View.INVISIBLE);
                    visto2pass2.setVisibility(View.INVISIBLE);
                }


                if(tenerpass2.length() < 4){
                    b1.setEnabled(false);
                }else{
                     b1.setEnabled(true);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String tenerpass1 = edt1.getText().toString();
                if(tenerpass1.length() == 0){
                    tv1.setText("Mientras mas compleja, mas segura");
                    tv1.setTextColor(Color.parseColor("#949494"));
                    tv1.setVisibility(View.VISIBLE);
                    tv2registrocorrecto.setVisibility(View.INVISIBLE);
                    tv3contraseñasincorrectas.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String tenerpass2 = edt2.getText().toString();
                if(tenerpass2.length() == 0){
                    tv1.setText("Mientras mas compleja, mas segura");
                    tv1.setTextColor(Color.parseColor("#949494"));
                    tv1.setVisibility(View.VISIBLE);
                    tv2registrocorrecto.setVisibility(View.INVISIBLE);
                    tv3contraseñasincorrectas.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        edt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String tenerpass2 = edt2.getText().toString();
                String tenerpass1 = edt1.getText().toString();
                if(tenerpass1.length() > 4){
                    visto1pass1.setVisibility(View.VISIBLE);
                    x1pass1.setVisibility(View.INVISIBLE);
                }else if(tenerpass1.length() < 4){
                    x1pass1.setVisibility(View.VISIBLE);
                    visto1pass1.setVisibility(View.INVISIBLE);
                }
                if(tenerpass1.length() == 0){
                    x1pass1.setVisibility(View.INVISIBLE);
                    visto1pass1.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void ver(View view){
        ver.setVisibility(View.VISIBLE);
        nover.setVisibility(View.INVISIBLE);
        edt1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        edt2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());


    }
    public void nover(View view){
        nover.setVisibility(View.VISIBLE);
        ver.setVisibility(View.INVISIBLE);
        edt2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edt1.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    public void guardar(View view){

        String tener1pass = edt1.getText().toString();
        String tener2pass = edt2.getText().toString();
        String tener = getIntent().getStringExtra("user");

        if(tener2pass.equals(tener1pass)){
            SharedPreferences pref1 = getSharedPreferences("pass", Context.MODE_PRIVATE);
            SharedPreferences.Editor objeditor = pref1.edit();
            objeditor.putString("pass",tener1pass);
            objeditor.commit();
            String a = pref1.getString("pass",Context.ACCESSIBILITY_SERVICE);
            SharedPreferences pref2 = getSharedPreferences("user", Context.MODE_PRIVATE);
            SharedPreferences.Editor objeditor2 = pref2.edit();
            objeditor.putString("user",tener);
            objeditor.commit();
            String a2 = pref1.getString("user",Context.ACCESSIBILITY_SERVICE);
            Intent llevardatos2 = new Intent(this,MainActivity.class);
            llevardatos2.putExtra("user",a2);
            llevardatos2.putExtra("pass",a);
            startActivity(llevardatos2);


        }else {
            start3();
            tv3contraseñasincorrectas.setVisibility(View.VISIBLE);
            tv1.setVisibility(View.INVISIBLE);
            tv2registrocorrecto.setVisibility(View.INVISIBLE);


        }


    }

    private void startanimacion(){
        Animation animacion = AnimationUtils.loadAnimation(this,R.anim.example);
        tv1.startAnimation(animacion);
    }
    private void start2(){
        Animation animacion = AnimationUtils.loadAnimation(this,R.anim.in);
        tv2registrocorrecto.startAnimation(animacion);
    }
    private void start3(){
        Animation animacion = AnimationUtils.loadAnimation(this,R.anim.in);
        tv3contraseñasincorrectas.startAnimation(animacion);
    }




    @Override
    protected void onResume() {
        super.onResume();
        tv1.setTextColor(Color.parseColor("#949494"));
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
    }

}
