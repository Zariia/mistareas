package com.example.sandra.proyecto;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sandra.proyecto.sql.ConexionSQLite;
import com.example.tareas.R;

import java.util.ArrayList;
import java.util.Collections;


public class VerTareas extends AppCompatActivity {

    ListView listaPendiente, listaRealizadas, listaTodas;
    // ArrayList<String> listaTodasTareas;
    // ArrayList<tareas> listaTareasRealizadas;
    ConexionSQLite conect;
    ArrayList<String> listaTareasPendientes;
    ArrayAdapter adaptador;
    public final static String detalle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_tareas);

        //Creamos un objeto LinearLayout y lo encontramos por su id
        LinearLayout ventana = findViewById(R.id.linear);
        ventana.setBackgroundColor(Color.TRANSPARENT);//Cambiamos el color de fondo del linearLayout

        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");
        //Identificamos la pestaña y le ponemos el texto
        spec.setContent(R.id.pendiente);
        spec.setIndicator("Pendientes");
        //res.getDrawable(android.R.drawable.ic_dialog_alert));
        tabs.addTab(spec);


        spec = tabs.newTabSpec("mitab2");
        //Identificamos la pestaña y le ponemos el texto
        spec.setContent(R.id.realizadas);
        spec.setIndicator("Realizadas");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab3");
        //Identificamos la pestaña y le ponemos el texto
        spec.setContent(R.id.todas);
        spec.setIndicator("Ver todas");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);//Al entrar aparecemos en la primera

        //Tareas pendientes**********************************************
        listaPendiente = (ListView) findViewById(R.id.listView);

        //Creo la conexión
        conect = new ConexionSQLite(this, ConexionSQLite.DATABASE_NAME, null, ConexionSQLite.DATABASE_VERSION);
        //Creo un objeto SQLiteDB para acceder en modo lectura, es un objeto cursor que nos recorre los campos
        SQLiteDatabase db = conect.getReadableDatabase();

        //Comprobamos si hay alguna tarea pendiente para ese usuario
        String query = "SELECT nombre_tarea FROM tareas;";

        //Guardamos en el cursor la consulta ejecutada
        Cursor tareasPendientes = db.rawQuery(query, null);

        //comprobamos que haya tareas
        if (tareasPendientes.getCount() > 0) {
            //Cogemos los datos del método llenar lista
            listaTareasPendientes = llenar_lv();
            adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTareasPendientes);
            listaPendiente.setAdapter(adaptador);

            //Ordeno la lista
            Collections.sort(listaTareasPendientes);
            //Lo muestro
            for (String temp : listaTareasPendientes) {
                System.out.print(temp);
            }

            //Cuando pulso una tarea
            listaPendiente.setOnItemClickListener((adapterView, view, position, id) -> {
                String valor = (String) adaptador.getItem(position);

                Intent intent = new Intent(getApplicationContext(), InformacionTarea.class);
                intent.putExtra(detalle, valor);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Pulsaste " + valor, Toast.LENGTH_LONG).show();
            });


        } else {
            System.out.println("No tienes tareas pendientes.");
        }

        //Tareas realizadas**********************************************
        listaRealizadas = (ListView) findViewById(R.id.listView2);


        //Comprobamos si hay alguna tarea pendiente para ese usuario
        String query2 = "SELECT nombre_tarea FROM tareas;";

        //Guardamos en el cursor la consulta ejecutada
        Cursor tareasRealizadas = db.rawQuery(query2, null);

        //comprobamos que haya tareas
        if (tareasRealizadas.getCount() > 0) {
            //Cogemos los datos del método llenar lista
            listaTareasPendientes = llenar_lv();
            adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTareasPendientes);
            listaRealizadas.setAdapter(adaptador);

            //Ordeno la lista
            Collections.sort(listaTareasPendientes);
            //Lo muestro
            for (String temp : listaTareasPendientes) {
                System.out.print(temp);
            }


            //Cuando pulso una tarea
            listaRealizadas.setOnItemClickListener((adapterView, view, position, id) -> {
                String valor = (String) adaptador.getItem(position);

                Intent intent = new Intent(getApplicationContext(), InformacionTarea.class);
                intent.putExtra(detalle, valor);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Pulsaste " + valor, Toast.LENGTH_LONG).show();
            });


        } else {
            System.out.println("No tienes tareas pendientes.");
        }


        //Tareas todas **************************************************************

        listaTodas = (ListView) findViewById(R.id.listView3);


        //Comprobamos si hay alguna tarea pendiente para ese usuario
        String query3 = "SELECT nombre_tarea FROM tareas;";

        //Guardamos en el cursor la consulta ejecutada
        Cursor tareasTodas = db.rawQuery(query3, null);

        //comprobamos que haya tareas
        if (tareasTodas.getCount() > 0) {
            //Cogemos los datos del método llenar lista
            listaTareasPendientes = llenar_lv();
            adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTareasPendientes);
            listaTodas.setAdapter(adaptador);

            //Ordeno la lista
            Collections.sort(listaTareasPendientes);
            //Lo muestro
            for (String temp : listaTareasPendientes) {
                System.out.print(temp);
            }


            //Cuando pulso una tarea
            listaTodas.setOnItemClickListener((adapterView, view, position, id) -> {
                String valor = (String) adaptador.getItem(position);

                Intent intent = new Intent(getApplicationContext(), InformacionTarea.class);
                intent.putExtra(detalle, valor);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Pulsaste " + valor, Toast.LENGTH_LONG).show();
            });


        } else {
            System.out.println("No tienes tareas asignadas.");
        }


    }

    //Método que llena el Array con la lista de tareas pendientes
    public ArrayList llenar_lv() {
        //Creo un array de string para devolver las tareas
        ArrayList<String> lista = new ArrayList<>();
        //Creo la conexión
        conect = new ConexionSQLite(this, ConexionSQLite.DATABASE_NAME, null, ConexionSQLite.DATABASE_VERSION);
        //Creo un objeto SQLiteDB para acceder en modo lectura, es un objeto cursor que nos recorre los campos
        SQLiteDatabase db = conect.getReadableDatabase();
        String query = "SELECT * FROM tareas";
        Cursor registros = db.rawQuery(query, null);

        //Nos colocamos al principio
        if (registros.moveToFirst()) {
            do {
                //Añadimos el id y el nombre de la tarea a la lsita
                lista.add(registros.getString(0) + " - " + registros.getString(1));
            } while (registros.moveToNext());//Pasamos a la siguiente tarea
        }
        return lista;
    }


    /*************************************** Menú ************************************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
            getOnBackPressedDispatcher().onBackPressed();
        } else if (id == R.id.cerrar) {
            Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

}
