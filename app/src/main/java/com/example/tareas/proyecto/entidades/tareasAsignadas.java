package com.example.tareas.proyecto.entidades;

import java.io.Serializable;
import java.sql.Date;

public class tareasAsignadas implements Serializable {
    private Integer id;
    private Date fechaAsignada;
    private Date fechaVencimiento;
    private Boolean realizada;
    private Integer idTarea;
    private Integer idUsuario;

    public tareasAsignadas(Integer id, Date fechaAsignada, Date fechaVencimiento, Boolean realizada, Integer idTarea, Integer idUsuario) {
        this.id = id;
        this.fechaAsignada = fechaAsignada;
        this.fechaVencimiento = fechaVencimiento;
        this.realizada = realizada;
        this.idTarea = idTarea;
        this.idUsuario = idUsuario;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(Date fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
