package com.example.lab7_20206456_20201638.Models.Beans;

public class Estadio {
    private int id_estadio;
    private String nombreEstadio;
    private String provincia;
    private String club;

    public int getId_estadio() {
        return id_estadio;
    }

    public void setId_estadio(int id_estadio) {
        this.id_estadio = id_estadio;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
