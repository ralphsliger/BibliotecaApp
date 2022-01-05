package com.bibliotecasofka.demo.mappers;

import com.bibliotecasofka.demo.dtos.RecursoDTO;
import com.bibliotecasofka.demo.models.Recurso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RecursoBibliotecaMapper {

    public Recurso fromDTO(RecursoDTO dto){
        Recurso recurso = new Recurso();
        recurso.setId(dto.getIdRecurso());
        recurso.setTipoRecurso(dto.getTipoRecurso());
        recurso.setDisponible(dto.getDisponible());
        recurso.setFechaPrestamo(dto.getFechaPrestamo());
        recurso.setNombre(dto.getNombre());
        recurso.setIdTematica(dto.getIdTematica());
        return recurso;
    }

    public RecursoDTO fromCollection(Recurso recurso){
        RecursoDTO recursoDTO = new RecursoDTO();
        recursoDTO.setIdRecurso(recurso.getId());
        recursoDTO.setTipoRecurso(recurso.getTipoRecurso());
        recursoDTO.setDisponible(recurso.getDisponible());
        recursoDTO.setFechaPrestamo(recurso.getFechaPrestamo());
        recurso.setNombre(recurso.getNombre());
        recurso.setIdTematica(recurso.getIdTematica());
        return recursoDTO;
    }

    public List<RecursoDTO> fromCollectionList(List<Recurso> collection){
        if(collection == null){
           return null;
        }

        List<RecursoDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Recurso recurso = (Recurso) listTracks.next();
            list.add(fromCollection(recurso));
        }
        return list;
    }
}
