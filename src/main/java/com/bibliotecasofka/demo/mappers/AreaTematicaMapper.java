package com.bibliotecasofka.demo.mappers;

import com.bibliotecasofka.demo.dtos.TematicaDTO;
import com.bibliotecasofka.demo.models.Tematica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AreaTematicaMapper {

    public Tematica fromDTO(TematicaDTO dto){
        Tematica tematica = new Tematica();
        tematica.setId(dto.getIdTematica());
        tematica.setCategoria(dto.getCategoriaTematica());
        return tematica;
    }

    public TematicaDTO fromCollection(Tematica tematica){
        TematicaDTO tematicaDTO = new TematicaDTO();
        tematicaDTO.setIdTematica(tematica.getId());
        tematicaDTO.setCategoriaTematica(tematica.getCategoria());
        return tematicaDTO;
    }

    public List<TematicaDTO> fromCollectionList(List<Tematica> collection){
        if(collection == null){
            return null;
        }
        List<TematicaDTO> list = new ArrayList<>(collection.size());
        Iterator listTracks = collection.iterator();
        while(listTracks.hasNext()){
            Tematica tematica = (Tematica) listTracks.next();
            list.add(fromCollection(tematica));
        }
        return list;
    }
}
