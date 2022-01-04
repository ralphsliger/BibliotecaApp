package com.bibliotecasofka.demo.dtos;

import java.util.List;

public class ListarTematicaDTO {
    private String tematica;
    private List<RecursoDTO> recursosTematica;

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public List<RecursoDTO> getRecursosTematica() {
        return recursosTematica;
    }

    public void setRecursosTematica(List<RecursoDTO> recursosTematica) {
        this.recursosTematica = recursosTematica;
    }
}
