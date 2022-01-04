package com.bibliotecasofka.demo.dtos;

import java.util.List;

public class ListarRecursoDeTematicaDTO {
    private String tipoTematica;
    private List<RecursoDTO> recursos;

    public String getTipoTematica() {
        return tipoTematica;
    }

    public void setTipoTematica(String tipoTematica) {
        this.tipoTematica = tipoTematica;
    }

    public List<RecursoDTO> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<RecursoDTO> recursos) {
        this.recursos = recursos;
    }
}
