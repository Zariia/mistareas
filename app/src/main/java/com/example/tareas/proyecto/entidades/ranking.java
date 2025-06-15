package com.example.tareas.proyecto.entidades;

import java.io.Serializable;

public class ranking implements Serializable {

    private Integer idRanking;
    private Integer idUsuario;
    private Integer puntos;

    public ranking(Integer idRanking, Integer idUsuario, Integer puntos) {
        this.idRanking = idRanking;
        this.idUsuario = idUsuario;
        this.puntos = puntos;
    }

    public Integer getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(Integer idRanking) {
        this.idRanking = idRanking;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
}
