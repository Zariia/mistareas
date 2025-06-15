package com.example.tareas.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tareas.proyecto.sql.ConexionSQLite;
import com.example.tareas.R;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        //Establecemos la conexión con la base de datos
        ConexionSQLite conexion = new ConexionSQLite(this, ConexionSQLite.DATABASE_NAME, null, ConexionSQLite.DATABASE_VERSION);

        //Creamos los cuatro botones con su id correspondiente
        Button verTareas;
        verTareas = (Button) findViewById(R.id.botonVerTareas);
        verTareas.setOnClickListener(this);

        Button anadirTareas;
        anadirTareas = (Button) findViewById(R.id.botonAnadirTareas);
        anadirTareas.setOnClickListener(this);

        Button editarTareas;
        editarTareas = (Button) findViewById(R.id.botonEditarTareas);
        editarTareas.setOnClickListener(this);

        Button verRanking;
        verRanking = (Button) findViewById(R.id.botonRanking);
        verRanking.setOnClickListener(this);
    }

    //Método que se ejecuta cuando pulsamos en un botón
    public void onClick(View view) {
        int id = view.getId();//Miramos cuál es el id del botón pulsado
        if (id == R.id.botonVerTareas) {
            Intent intent = new Intent(Principal.this, VerTareas.class);
            startActivity(intent);
        }
        if (id == R.id.botonEditarTareas) {
            Intent intent2 = new Intent(Principal.this, EditarTareas.class);
            startActivity(intent2);
        }
        if (id == R.id.botonRanking) {
            Intent intent3 = new Intent(Principal.this, VerRanking.class);
            startActivity(intent3);
        }
        if (id == R.id.botonAnadirTareas) {
            Intent intent4 = new Intent(Principal.this, AniadirTareas.class);
            startActivity(intent4);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflamos el menú
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //Miramos cuál de los dos marcó
        if (id == R.id.salir) {//Si eligió salir cerramos la aplicación
            //Creamos un intent para llamar a la clase principal(main)
            Intent intent = new Intent(Intent.ACTION_MAIN);
            //al llamarla se borran todas las actividades que llamamos
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //al iniciarla no hay nada y manda al inicio
            startActivity(intent);
        } else if (id == R.id.principal) {
            Toast.makeText(this, "Ir al principio", Toast.LENGTH_LONG).show();
        } else if (id == R.id.cerrar) {
            Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


}
