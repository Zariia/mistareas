package com.example.tareas.proyecto;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tareas.proyecto.sql.ConexionSQLite;
import com.example.tareas.R;
import com.google.android.material.snackbar.Snackbar;

public class RegistrarUsuario extends AppCompatActivity {

    EditText campoNombre, campoApellido, campoNick, campoClave, campoAnio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        campoNombre = findViewById(R.id.campoNombre);
        campoApellido = findViewById(R.id.campoApellido);
        campoNick = findViewById(R.id.campoNick);
        campoClave = findViewById(R.id.campoClave);
        campoAnio = findViewById(R.id.campoAnio);
    }

    public void registrarUsuarios(View v) {
        //Creo la conexión
        ConexionSQLite conect = new ConexionSQLite(this, ConexionSQLite.DATABASE_NAME, null, ConexionSQLite.DATABASE_VERSION);

        //Creo un objeto SQLiteDB para editar la base de datos
        SQLiteDatabase db = conect.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            //Comprobamos que todos los campos contengan sus datos correspondientes
            if (campoNombre.getText().toString().isEmpty() || campoApellido.getText().toString().isEmpty() || campoNick.getText().toString().isEmpty() || campoClave.getText().toString().isEmpty() || campoAnio.getText().toString().isEmpty()) {  //Comprobamos que estén todos rellenos
                Snackbar.make(findViewById(android.R.id.content), "Rellena todos los campos para registrarte", Snackbar.LENGTH_SHORT).show();
            } else {//Si están todos rellenos los insertamos
                ContentValues values = new ContentValues();

                values.put(ConexionSQLite.COLUMNA_NOMBRE, campoNombre.getText().toString());
                values.put(ConexionSQLite.COLUMNA_APELLIDO, campoApellido.getText().toString());
                values.put(ConexionSQLite.COLUMNA_NICK, campoNick.getText().toString());
                values.put(ConexionSQLite.COLUMNA_CLAVE, campoClave.getText().toString());
                values.put(ConexionSQLite.COLUMNA_ANIO, campoAnio.getText().toString());

                //Insertamos los datos escritos por el usuario
                db.insert(ConexionSQLite.TABLA_USUARIO, null, values);

                //Agregamos tres tareas al usuario
                //tareasAsignadas fecha actual id tarea id usuario


                db.close();//Cerramos la conexión

                //Creamos un intent que le lleva a logueo una vez registrado y asignadas sus tareas
                Intent intent = new Intent(RegistrarUsuario.this, LoguearUsuario.class);

                //Si el intent no está vacío vamos a logearnos
                if (intent != null) {
                    startActivity(intent);
                }
            }
        } else {
            Toast.makeText(this, "noooo", Toast.LENGTH_SHORT).show();
        }


    }


    /*************************************** Menú ************************************************/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflamos el menú
        getMenuInflater().inflate(R.menu.menu_index, menu);
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
        } else if (id == R.id.instrucciones) {
            Toast.makeText(this, "Ir a instrucciones", Toast.LENGTH_LONG).show();
        } else if (id == R.id.ajustes) {
            Toast.makeText(this, "Ir a ajustes", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


}
