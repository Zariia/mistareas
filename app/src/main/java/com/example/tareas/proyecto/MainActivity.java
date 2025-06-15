package com.example.tareas.proyecto;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tareas.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private View mLoginFormView;
    private View mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        username = (EditText) findViewById(R.id.logUsuario);
        password = (EditText) findViewById(R.id.logClave);
        mLoginFormView= findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        Button register;
        register = findViewById(R.id.register_btn);
        register.setOnClickListener(this);

        Button login;
        login = findViewById(R.id.login_btn);
        login.setOnClickListener(this);
    }


    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.login_btn) {
            showProgress(true);
            if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                showProgress(false);
                Intent intent = new Intent(MainActivity.this, Principal.class);
                startActivity(intent);
            }else
                showProgress(false);
        } else if (id == R.id.register_btn) {
            Intent intent2 = new Intent(MainActivity.this, RegistrarUsuario.class);
            startActivity(intent2);
        }
    }

    //==============================================================================================
    //                  CARGAR ANIMACION DE UNA BARRA DE PROGRESO CIRCULAR
    //==============================================================================================
   // @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.

            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
    }

}
