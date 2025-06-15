package com.example.tareas.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tareas.R;

public class EditarTareas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_tareas);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
            //vuelve a la Actividad anterior a la que te encuentras ahora
            onBackPressed();
        } else if (id == R.id.cerrar) {
            Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
