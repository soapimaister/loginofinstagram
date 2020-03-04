package com.example.sdbitacora;

import androidx.annotation.FontRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.PersistableBundle;
import android.service.autofill.UserData;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText edt1user, edt2pass;
    private TextView tv1, tv2, tv3, tv4, tv5, tvN, tvP;
    private Spinner sp1;
    private Button b1;
    private ImageButton ver, nover;
    private ProgressBar pr1;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            edt1user = (EditText) findViewById(R.id.edtuser);
            edt2pass = (EditText) findViewById(R.id.edtp);
            tv1 = (TextView) findViewById(R.id.tv1);
            tv2 = (TextView) findViewById(R.id.tv2);
            tv3 = (TextView) findViewById(R.id.tv3);
            tv4 = (TextView) findViewById(R.id.tv4);
            tv5 = (TextView) findViewById(R.id.tv5);
            sp1 = (Spinner) findViewById(R.id.spinner);
            b1 = (Button) findViewById(R.id.button3);
            ver = (ImageButton) findViewById(R.id.ver);
            nover = (ImageButton) findViewById(R.id.nover);
            tvN = (TextView) findViewById(R.id.TVN);
            tvP = (TextView) findViewById(R.id.TVP);
            pr1 = (ProgressBar) findViewById(R.id.progressBar1);

            pr1.setVisibility(View.INVISIBLE);
            ver.setVisibility(View.INVISIBLE);




            String[] idiomas = {"Spanish (Estados Unidos)", "English (Estados Unidos)"};
            final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.spinner, idiomas);
            sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String seleccion = sp1.getSelectedItem().toString();
                    if (seleccion.equals("English (Estados Unidos)")) {
                        {
                            edt1user.setHint("Phone, email or username");
                            edt2pass.setHint("Password");
                            tv1.setText("              Forgot your login details?");
                            tv2.setText("Get help signing in");
                            tv3.setText("Log in with Facebook");
                            tv4.setText("Don't have an account?");
                            tv5.setText("Sign up.");
                            b1.setText("Login");
                            Toast.makeText(MainActivity.this, "English", Toast.LENGTH_SHORT).show();
                        }
                    } else if (seleccion.equals("Spanish (Estados Unidos)")) {
                        edt1user.setHint("Teléfono, correo electrónico o usuario");
                        edt2pass.setHint("Contraseña");
                        tv1.setText("¿Olvidaste tus datos de inicio de sesión?");
                        tv2.setText("Obtén ayuda.");
                        tv3.setText("Iniciar sesión con Facebook");
                        tv4.setText("¿No tienes una cuenta?");
                        tv5.setText("Regístrate.");
                        b1.setText("Iniciar sesión");
                        Toast.makeText(MainActivity.this, "Español", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            sp1.setAdapter(adaptador);

            b1.setEnabled(false);


            edt2pass.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String s = edt1user.getText().toString();
                    String p = edt2pass.getText().toString();
                    if (p.length() < 4) {
                        b1.setEnabled(false);
                    } else if (p.length() > 4) {
                        b1.setEnabled(true);
                    }

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            edt2pass.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String a = edt2pass.getText().toString();
                    if (a.length() == 0) {
                        nover.setVisibility(View.VISIBLE);
                        ver.setVisibility(View.INVISIBLE);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            tv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent irayuda = new Intent(MainActivity.this, Main2Activity.class);
                    irayuda.putExtra("helpinstagram", "https://help.instagram.com/");
                    startActivity(irayuda);
                    overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);
                    tv2.setTextColor(Color.parseColor("#949494"));

                }
            });

            tv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent irfb = new Intent(MainActivity.this, Main3Activity.class);
                    irfb.putExtra("fb", "https://t.co/9RXt2QotJY?amp=1");
                    startActivity(irfb);
                    overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                    tv3.setTextColor(Color.parseColor("#6D97E8"));

                }
            });

            tv5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent llevarregistro = new Intent(MainActivity.this, Main4Activity.class);
                    llevarregistro.putExtra("registro", "");
                    startActivity(llevarregistro);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    tv5.setTextColor(Color.parseColor("#949494"));
                }
            });



            String u = edt1user.getText().toString();
            String p = edt2pass.getText().toString();



            SharedPreferences tener2 = getSharedPreferences("user", Context.MODE_PRIVATE);
            final String user = tener2.getString("user", "");
            SharedPreferences tener3 = getSharedPreferences("pass", MODE_PRIVATE);
            final String pass2 = tener3.getString("pass", "");
            tvN.setText(user);
            tvP.setText(pass2);
            String userypass[] = {user, pass2};
            String nombre = userypass[0];
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String u = edt1user.getText().toString();
                    String p = edt2pass.getText().toString();
                    String userypass[] = {user, pass2};
                    String nombre = userypass[0];
                    if (u.equals(userypass[0]) && p.equals(userypass[1])) {
                        pr1.setVisibility(View.VISIBLE);
                        b1.setVisibility(View.INVISIBLE);
                        Intent nuevo = new Intent(MainActivity.this, Main6Activity.class);
                        startActivity(nuevo);
                        finish();

                    } else if (u.equals(userypass[0]) == true && p.equals(userypass[1]) == false) {
                        pr1.setVisibility(View.VISIBLE);
                        b1.setVisibility(View.INVISIBLE);
                        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this, AlertDialog.THEME_HOLO_LIGHT);
                        alerta.setMessage("Contraseña incorrecta para " + nombre);
                        alerta.setPositiveButton("Intentar de nuevo", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                b1.setVisibility(View.VISIBLE);
                                pr1.setVisibility(View.INVISIBLE);
                            }
                        });
                        alerta.setCancelable(true);
                        alerta.create().show();


                    } else if (u.equals(userypass[0]) == false) {
                        Toast.makeText(MainActivity.this, "Usuario no existente", Toast.LENGTH_SHORT).show();

                    }
                }
            });



        }


        public void ver(View view) {
            ver.setVisibility(View.VISIBLE);
            nover.setVisibility(View.INVISIBLE);
            edt2pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

        }

        public void nover(View view) {
            nover.setVisibility(View.VISIBLE);
            ver.setVisibility(View.INVISIBLE);
            edt2pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }

        @Override
        protected void onResume() {
            super.onResume();
            tv2.setTextColor(Color.parseColor("#011899"));
            tv3.setTextColor(Color.parseColor("#4267b2"));
            tv5.setTextColor(Color.parseColor("#011899"));
            pr1.setVisibility(View.INVISIBLE);


        }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new  AlertDialog.Builder(MainActivity.this,AlertDialog.THEME_HOLO_LIGHT);
        alerta.setMessage("¿Seguro que quiere salir?");
        alerta.setPositiveButton("Seguro", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();



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










