package com.bibliotecasofka.demo.dtos;

public class RecursoDTO {
    private String idRecurso;
    private String tipoRecurso;
    private Boolean disponible;
    private String fechaPrestamo;
    private String nombre;
    private String idTematica;

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdTematica() {
        return idTematica;
    }

    public void setIdTematica(String idTematica) {
        this.idTematica = idTematica;
    }
}
