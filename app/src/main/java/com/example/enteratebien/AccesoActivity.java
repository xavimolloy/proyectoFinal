package com.example.enteratebien;


import android.os.*;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class AccesoActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button Acceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        Acceder = findViewById(R.id.LogInWithEmail);
        textInputEditTextUsername = findViewById(R.id.login_username);
        textInputEditTextPassword = findViewById(R.id.login_contrasenya);
        Acceder.setOnClickListener(v -> {


            String username, password;

            username = String.valueOf(textInputEditTextUsername.getText());
            password = String.valueOf(textInputEditTextPassword.getText());


            if(!username.equals("") && !password.equals("")){


                Handler handler = new Handler(Looper.myLooper());
                handler.post(() -> {
                    String[] field = new String[2];

                    field[0] = "username";
                    field[1] = "password";


                    String[] data= new String[2];

                    data[0] = username;
                    data[1] = password;
                    PutData putData = new PutData("http://192.168.8.100/LoginRegister/login.php?_ijt=rnv818nag2t4mocvifd7jcd9t", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            String result = putData.getResult();
                            //End ProgressBar (Set visibility to GONE)
                            if (result.equals("Login Success")){
                                Toast.makeText(getApplicationContext(),"Has iniciado sesión correctamente", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(this, PostLoginActivity.class);
                                startActivity(intent);

                                finish();
                            }else{
                                Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                            }

                        }
                    }


                });
            }
            else{
                Toast.makeText(getApplicationContext(),"Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            }

        });


    }





}


