package com.example.sandra.proyecto.sql;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

/**
 * Created by Sandra on 27/02/2018.
 */

public class ConexionSQLite extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;//Versión de la base de datos
    public static final String DATABASE_NAME = "lasTareas.db";//Nombre de la base de datos

    //Creamos la tabla usuario con el nombre de sus campos o columnas
    public static final String TABLA_USUARIO = "usuario";
    public static final String COLUMNA_IDUSUARIOS = "id_usuario";
    public static final String COLUMNA_NOMBRE = "nombre_usuario";
    public static final String COLUMNA_APELLIDO = "apellido_usuario";
    public static final String COLUMNA_NICK = "usuario_nick";
    public static final String COLUMNA_CLAVE = "clave";
    public static final String COLUMNA_ANIO = "anio_nacido";


    //Creamos la tabla usuario que contendrá a todos los miembros de la familia
    private static final String SQL_CREAR_USUARIO  = "CREATE TABLE "+TABLA_USUARIO +
            " ("+COLUMNA_IDUSUARIOS+" INTEGER PRIMARY KEY AUTOINCREMENT," +COLUMNA_NOMBRE+" TEXT NOT NULL,"
            +COLUMNA_APELLIDO+" TEXT NOT NULL,"+COLUMNA_NICK+" TEXT NOT NULL,"+COLUMNA_CLAVE+" TEXT NOT NULL,"+COLUMNA_ANIO+" INTEGER NOT NULL)";


    /* Creamos la tabla TAREAS */
    public static final String TABLA_TAREAS = "tareas";
    public static final String COLUMNA_IDTAREA = "id_tarea";
	public static final String COLUMNA_NOMBRET = "nombre_tarea";
    public static final String COLUMNA_DESCRIPCION = "descripcion_tarea";
    public static final String COLUMNA_TIEMPOMEDIO= "tiempo_medio";
    public static final String COLUMNA_NIVELDIFICULTAD = "nivel_dificultad";



    //Creamos la tabla tareas que contendrá todas las tareas
    private static final String SQL_CREAR_TAREAS="CREATE TABLE "+TABLA_TAREAS +" ("+COLUMNA_IDTAREA+
            " INTEGER PRIMARY KEY AUTOINCREMENT," +COLUMNA_NOMBRET+" TEXT NOT NULL,"+COLUMNA_DESCRIPCION+" TEXT NOT NULL,"
            +COLUMNA_TIEMPOMEDIO+" INTEGER NOT NULL,"+COLUMNA_NIVELDIFICULTAD+" INTEGER NOT NULL)";

			
	/* Creamos la tabla RANKING */
    public static final String TABLA_RANKING = "ranking";
	public static final String COLUMNA_IDRANKING = "id_ranking";
    public static final String COLUMNA_IDUSUARIO = "id_usuario";
	public static final String COLUMNA_PUNTOS = "puntos";
			

    //Creamos la tabla ranking que contendrá los puntos de los usuarios
    private static final String SQL_CREAR_RANKING="CREATE TABLE "+TABLA_RANKING+" ("+COLUMNA_IDRANKING+
	"INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMNA_IDUSUARIO+"INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMNA_PUNTOS+"INTEGER NOT NULL)";
	
	/* Creamos la tabla TAREASASIGNADAS */
    public static final String TABLA_TAREASASIGNADAS = "tareasAsignadas";
    public static final String COLUMNA_IDTAREAASIGNADA = "id_tarea_asignada";
	public static final String COLUMNA_FECHAASIGNADA = "fecha_asignada";
	public static final String COLUMNA_FECHAVENCIMIENTO = "fecha_vencimiento";
    public static final String COLUMNA_REALIZADA = "realizada";
	public static final String COLUMNA_IDTAREAASIG = "id_tarea";
	public static final String COLUMNA_IDUSUARIOTAREAASIG = "id_usuario";
	/*
	cREATE TABLE something (
  column1 INTEGER NOT NULL,
  column2 INTEGER NOT NULL,
  value,
  PRIMARY KEY ( column1, column2));    "FOREIGN KEY(
	*/

    //Creamos la tabla tareasAsignadas que contendrá a cada usuario con las tareas que tiene asignadas
    private static final String SQL_CREAR_TAREASASIGNADAS="CREATE TABLE "+TABLA_TAREASASIGNADAS+" ("+COLUMNA_IDTAREAASIGNADA+
            "INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMNA_FECHAASIGNADA+"INTEGER,"+COLUMNA_FECHAVENCIMIENTO+"INTEGER,"+COLUMNA_REALIZADA+"BOOLEAN,"+COLUMNA_IDTAREAASIG+"INTEGER,"+COLUMNA_IDUSUARIOTAREAASIG+"INTEGER)";

    private static final String Insertar1="INSERT INTO "+ConexionSQLite.TABLA_TAREAS +" VALUES('1','Fregar los platos','Fregar los platos, vasos y cubiertos de todo el día','30','0')";
    private static final String Insertar2="INSERT INTO "+ConexionSQLite.TABLA_TAREAS+" VALUES('2','Planchar la ropa','Planchar la ropa que esté por planchar','20','1')";
    private static final String Insertar3="INSERT INTO "+ConexionSQLite.TABLA_TAREAS+" VALUES('3','Poner la lavadora','Poner la lavadora o lavar la ropa del modo que sea ','60','1')";
    private static final String Insertar4="INSERT INTO "+ConexionSQLite.TABLA_TAREAS+" VALUES('4','Hacer la comida','Hacer la comida para todos','25','1')";
    private static final String Insertar5="INSERT INTO "+ConexionSQLite.TABLA_TAREAS+" VALUES('5','Hacer la cena','Hacer la comida para todos ','02','0')";
    private static final String Insertar6="INSERT INTO "+ConexionSQLite.TABLA_TAREAS+" VALUES('6','Hacer la compra','Vamos a fregar mucho ','02','1')";
    private static final String Insertar7="INSERT INTO "+ConexionSQLite.TABLA_TAREAS+" VALUES('7','Hacer las camas','Vamos a fregar mucho ','02','0')";
    private static final String Insertar8="INSERT INTO "+ConexionSQLite.TABLA_TAREAS+" VALUES('8','Barrer la casa','Barrer toda la casa ','02','0')";
    private static final String Insertar9="INSERT INTO "+ConexionSQLite.TABLA_TAREAS+" VALUES('9','Limpiar le baño','Vamos a fregar mucho ','02','0')";
    private static final String Insertar10="INSERT INTO "+ConexionSQLite.TABLA_TAREAS+" VALUES('10','Recoger la mesa','Recoger la mesa durante todo el día','15','0')";
    private static final String Insertar11="INSERT INTO "+ConexionSQLite.TABLA_TAREAS+" VALUES('11','Recoger la casa','Recoger ','gfh','0')";




    //Constructor
    public ConexionSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crea la tabla usuario
        db.execSQL(SQL_CREAR_USUARIO);
        //Crea la tabla tareas
        db.execSQL(SQL_CREAR_TAREAS);
        //Crea la tabla ranking
		//db.execSQL(SQL_CREAR_RANKING);
        //Crea la tabla tareas asignadas
		//db.execSQL(SQL_CREAR_TAREASASIGNADAS);

        //Insertamos las tareas que tendrá siempre
		db.execSQL(Insertar1);
        db.execSQL(Insertar2);
        db.execSQL(Insertar3);
        db.execSQL(Insertar4);
        db.execSQL(Insertar5);
        db.execSQL(Insertar6);
        db.execSQL(Insertar7);
        db.execSQL(Insertar8);
        db.execSQL(Insertar9);
        db.execSQL(Insertar10);
        db.execSQL(Insertar11);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int antiguaVersion, int nuevaVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+TABLA_TAREAS);
       // db.execSQL("DROP TABLE IF EXISTS "+TABLA_TAREASASIGNADAS);
        //db.execSQL("DROP TABLE IF EXISTS "+TABLA_RANKING);
        onCreate(db);
    }
}