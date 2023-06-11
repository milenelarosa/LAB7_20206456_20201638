package com.example.lab7_20206456_20201638.Models.Dtos;

import com.example.lab7_20206456_20201638.Models.Beans.Estadio;

public class ListarSeleccionesDto {
    private int idSeleccion;
    private String nombre;
    private String tecnico;
    private int idEstadio;
    private String primerPartido;
    private Estadio estadio;


    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }

    public String getPrimerPartido() {
        return primerPartido;
    }

    public void setPrimerPartido(String primerPartido) {
        this.primerPartido = primerPartido;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }
}
