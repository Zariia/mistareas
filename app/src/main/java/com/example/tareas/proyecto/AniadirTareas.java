package com.example.tareas.proyecto;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tareas.proyecto.sql.ConexionSQLite;
import com.example.tareas.R;


public class AniadirTareas extends AppCompatActivity {
    private EditText campoNombre, campoDescripcion, campoTiempo;
    private RadioButton radioFacil, radioDificil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aniadir_tareas);

        //Identificamos cada editText y cada radioButton
        campoNombre =  findViewById(R.id.campoNombre);
        campoDescripcion =  findViewById(R.id.campoDescripcion);
        campoTiempo =  findViewById(R.id.campoTiempo);
        radioFacil =  findViewById(R.id.radioButtonFacil);
        radioDificil =  findViewById(R.id.radioButtonComplicado);
    }


    //Este método se ejecutará cuando se presione el botón de agregar tarea
    public void agregarTarea(View view) {
        String nombreTareaNueva, descripcionTareaNueva;
        int dificultad, tiempoTarea;

        //Si el usuario relleno los tres campos entramos
        if (!campoNombre.getText().toString().isEmpty() && !campoDescripcion.getText().toString().isEmpty() && !campoTiempo.getText().toString().isEmpty()) {
            //Si el usuario marcó algún radioButton entramos
            if (radioDificil.isChecked() != false || radioFacil.isChecked() != false) {

                //Creo la conexión
                ConexionSQLite conect = new ConexionSQLite(this, ConexionSQLite.DATABASE_NAME, null, ConexionSQLite.DATABASE_VERSION);

                //Creo un objeto SQLiteDB para editar la base de datos
                SQLiteDatabase db = conect.getWritableDatabase();

                //Si hemos abierto correctamente la base de datos
                if (db != null) {

                    //Si ha marcado un radioButton cogemos cual y el resto de datos
                    if (radioFacil.isChecked() == true) {
                        //Guardamos en un string
                        dificultad = 0;

                    } else {
                        //Guardamos en un string
                        dificultad = 1;
                    }
                    nombreTareaNueva = campoNombre.getText().toString();
                    descripcionTareaNueva = campoDescripcion.getText().toString();
                    tiempoTarea = Integer.parseInt(campoTiempo.getText().toString());


                    ContentValues values = new ContentValues();


                    values.put(ConexionSQLite.COLUMNA_NOMBRET, nombreTareaNueva);
                    values.put(ConexionSQLite.COLUMNA_DESCRIPCION, descripcionTareaNueva);
                    values.put(ConexionSQLite.COLUMNA_TIEMPOMEDIO, tiempoTarea);
                    values.put(ConexionSQLite.COLUMNA_NIVELDIFICULTAD, dificultad);

                    //Insertamos los datos escritos por el usuario
                    db.insert(ConexionSQLite.TABLA_TAREAS, null, values);

                    //Ponemos los campos vacíos
                    campoNombre.setText("");
                    campoDescripcion.setText("");
                    campoTiempo.setText("");
                    //Desmarcar radiobutton
                    radioDificil.setChecked(false);
                    radioFacil.setChecked(false);

                    db.close();//Cerramos la conexión

                }//Fin db no null

            } else {
                //Sacamos un diálogo de que debe marcar uno
                Dialogos dialogo = new Dialogos();
                dialogo.show(this.getFragmentManager(), "tagAlerta");
            }
        } else {
            Toast toast2 = Toast.makeText(getApplicationContext(), "Rellene todos los datos.", Toast.LENGTH_SHORT);
            toast2.show();
        }


    }

//Cogemos los datos
    //Miramos que esten bien
    //Los guardamos en historico?¿id y bbdd
    //Vaciamos los campos y mantenemos aqui avisando de que se guardo


    /*************************************** Menú ************************************************/
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
