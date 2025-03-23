package com.example.sandra.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tareas.R;

public class LoguearUsuario {
    EditText usuario1, clave;



    //    usuario1 = (EditText) findViewById(R.id.logUsuario);
    //    clave = (EditText) findViewById(R.id.logClave);

    //Miramos que dia es por si hay que resetear o dar puntos o que?¿


    //Método que comprueba si es correcto el usuario y la clave introducidos
    public void comprobarLogueo(View v) {
        //Establecemos la conexión con la base de datos
        //ConexionSQLite conexion=new ConexionSQLite(this,ConexionSQLite.DATABASE_NAME,null,ConexionSQLite.DATABASE_VERSION);

        //Creo un objeto SQLiteDB para editar la base de datos
        //SQLiteDatabase db=conexion.getReadableDatabase();

        //Cojo lo escrito por el usuario
        //String usuarioLogueo=usuario1.getText().toString();
        //String claveLogueo=clave.getText().toString();

        //Realizo la consulta y la guardo en una variable
        //String query="SELECT id_usuario,nombre_usuario,clave FROM usuario WHERE usuario_nick='"+usuarioLogueo+"' and clave='"+claveLogueo+"';";

        //consulto a ver
        //Cursor fila=db.rawQuery(query,null);

       /* try {

            //preguntamos si el cursor tiene algun valor almacenado
            if (fila.moveToFirst()) {
                //capturamos los valores del cursos y lo almacenamos en variable
                int id_usuario = fila.getInt(0);
                String nombre_usuario = fila.getString(1);
                String contrasenia_usuario = fila.getString(2);
                //preguntamos si los datos ingresados son iguales
                if (usuarioLogueo.equals(nombre_usuario) && claveLogueo.equals(contrasenia_usuario)){
                    //si son iguales entonces vamos a la ventana principal y mandamos el id del usuarioz------------------------------*/
        //Comprobamos que tenga tareas asignadas hoy
        //Sino le asignamos 3 tareas

        //limpiamos las cajas de texto
        //usuario1.setText("");
        //clave.setText("");

                 /* }else{
                    //limpiamos las cajas de texto
                    usuario1.setText("");
                    clave.setText("");
                    Toast.makeText(this, "Usuario o clave incorrecta", Toast.LENGTH_SHORT).show();
                }
            }//fin if
        }catch(Exception ex){
            Log.e("Base datos","Error al leer la bd");
        }
        fila.close();*/
        //db.close();
    }//fin comprobar logueo

}
