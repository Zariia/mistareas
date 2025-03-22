package com.example.sandra.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tareas.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Button register;
        register = findViewById(R.id.btnRegistro);
        register.setOnClickListener(this);

        Button login;
        login = findViewById(R.id.botonLogearse);
        login.setOnClickListener(this);
    }


    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.botonLogearse) {
            Intent intent = new Intent(MainActivity.this, LoguearUsuario.class);
            startActivity(intent);
        } else if (id == R.id.btnRegistro) {
            Intent intent2 = new Intent(MainActivity.this, RegistrarUsuario.class);
            startActivity(intent2);
        }
    }

}
