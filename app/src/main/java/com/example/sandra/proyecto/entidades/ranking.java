package com.example.sandra.proyecto.entidades;

import java.io.Serializable;

/**
 * Created by Sandra on 27/02/2018.
 */

public class ranking implements Serializable {
    //Atributos de ranking
    private Integer idRanking;
    private Integer idUsuario;
    private Integer puntos;

    //Constructor con parámetros
    public ranking(Integer idRanking, Integer idUsuario, Integer puntos) {
        this.idRanking = idRanking;
        this.idUsuario = idUsuario;
        this.puntos = puntos;
    }


    //Constructor sin parámetros
    public ranking(){

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
