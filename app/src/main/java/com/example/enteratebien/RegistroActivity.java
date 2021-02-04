package com.example.enteratebien;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class RegistroActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextFullName, textInputEditTextUserName, textInputEditTextPassword, textInputEditTextEmail;
    Button RegistrarNuevoUsuario;
    TextView textViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        textInputEditTextFullName = findViewById(R.id.nombrecompletoRegistro);
        textInputEditTextEmail = findViewById(R.id.email_Registro);
        textInputEditTextUserName = findViewById(R.id.nombreusuarioRegistro);
        textInputEditTextPassword = findViewById(R.id.contrasenya_Registro);
        RegistrarNuevoUsuario= findViewById(R.id.boton_nuevo_usuario);

        RegistrarNuevoUsuario.setOnClickListener(v -> {


            String fullname, username, password, email;
            fullname = String.valueOf(textInputEditTextFullName.getText());
            username = String.valueOf(textInputEditTextUserName.getText());
            password = String.valueOf(textInputEditTextPassword.getText());
            email = String.valueOf(textInputEditTextEmail.getText());

            if(!fullname.equals("") &&!username.equals("") && !email.equals("") && !password.equals("")){


            Handler handler = new Handler(Looper.myLooper());
            handler.post(() -> {
                String[] field = new String[4];
                field[0] = "fullname";
                field[1] = "username";
                field[2] = "password";
                field[3] = "email";

                String[] data= new String[4];
                data[0] = fullname;
                data[1] = username;
                data[2] = password;
                data[3] = email;
                PutData putData = new PutData("http://192.168.8.100/LoginRegister/signup.php?_ijt=79uipq4q3e07adv1m15uaf9cq0", "POST", field, data);
                if (putData.startPut()) {
                    if (putData.onComplete()) {
                        String result = putData.getResult();
                        //End ProgressBar (Set visibility to GONE)
                        if (result.equals("Sign Up Success")){
                            Toast.makeText(getApplicationContext(),"Has iniciado sesión correctamente", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(this, AccesoActivity.class);
                            startActivity(intent);

                            finish();
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


