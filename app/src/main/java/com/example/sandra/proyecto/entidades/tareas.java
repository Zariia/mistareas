package com.example.sandra.proyecto.entidades;

import java.io.Serializable;

/**
 * Created by Sandra on 27/02/2018.
 */

public class tareas implements Serializable {
    //Atributos de la tabla tareas
    private Integer idTarea;
    private String nombre;
    private String descripcion;
    private Integer tiempoMedio;
    private Boolean nivelDificultad;

    //Constructor con parámetros
    public tareas(Integer idTarea, String nombre, String descripcion, Integer tiempoMedio, Boolean nivelDificultad) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempoMedio = tiempoMedio;
        this.nivelDificultad = nivelDificultad;
    }

    //Constructor sin parámetros
    public tareas(){

    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTiempoMedio() {
        return tiempoMedio;
    }

    public void setTiempoMedio(Integer tiempoMedio) {
        this.tiempoMedio = tiempoMedio;
    }

    public Boolean getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(Boolean nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }
}
