package com.example.lab7_20206456_20201638.Models.Beans;

import java.util.Date;

public class Partido {
    private int idPartido;
    private Date fecha;
    private int numJornada;
    private int seleccionLocal;
    private int seleccionVisitante;
    private int arbitro;


    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public int getSeleccionLocal() {
        return seleccionLocal;
    }

    public void setSeleccionLocal(int seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public int getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public void setSeleccionVisitante(int seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }

    public int getArbitro() {
        return arbitro;
    }

    public void setArbitro(int arbitro) {
        this.arbitro = arbitro;
    }
}
