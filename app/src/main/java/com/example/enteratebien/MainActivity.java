package com.example.enteratebien;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button GoToRegister = findViewById(R.id.GoToRegister);
        Button GoToAccess = findViewById(R.id.GoToAccess);
        GoToAccess.setOnClickListener(v -> {
            Intent intent = new Intent(this, AccesoActivity.class );
            startActivity(intent);
        });
        GoToRegister.setOnClickListener( v -> {
            Toast.makeText(this,"Todos los campos son obligatorios", Toast.LENGTH_SHORT);

            Intent intent = new Intent(this, RegistroActivity.class);
            startActivity(intent);

        });
    }
}