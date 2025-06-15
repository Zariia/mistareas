package com.example.tareas.proyecto.entidades;

import java.io.Serializable;

public class usuario implements Serializable{
    //Atributos de usuario
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String nick;
    private String clave;
    private Integer anioNacido;


    public usuario(Integer idUsuario, String nombre, String apellido, String nick, String clave, Integer anioNacido) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.clave = clave;
        this.anioNacido = anioNacido;
    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getAnioNacido() {
        return anioNacido;
    }

    public void setAnioNacido(Integer anioNacido) {
        this.anioNacido = anioNacido;
    }
}
