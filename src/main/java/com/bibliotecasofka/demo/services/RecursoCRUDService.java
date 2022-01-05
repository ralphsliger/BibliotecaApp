package com.bibliotecasofka.demo.services;

import com.bibliotecasofka.demo.dtos.RecursoDTO;
import com.bibliotecasofka.demo.dtos.TematicaDTO;
import com.bibliotecasofka.demo.mappers.AreaTematicaMapper;
import com.bibliotecasofka.demo.mappers.RecursoBibliotecaMapper;
import com.bibliotecasofka.demo.models.Recurso;
import com.bibliotecasofka.demo.models.Tematica;
import com.bibliotecasofka.demo.repositories.AreaTematicaRepository;
import com.bibliotecasofka.demo.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoCRUDService {
    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private AreaTematicaRepository areaTematicaRepository;

    private RecursoBibliotecaMapper recursoMapper = new RecursoBibliotecaMapper();
    private AreaTematicaMapper areaMapper = new AreaTematicaMapper();

    public TematicaDTO crearAreaTematica(TematicaDTO dto){
        Tematica tematica = areaMapper.fromDTO(dto);
        return areaMapper.fromCollection(areaTematicaRepository.save(tematica));
    }

    public RecursoDTO crearRecurso(RecursoDTO dto){
        Recurso recurso = recursoMapper.fromDTO(dto);
        return recursoMapper.fromCollection(recursoRepository.save(recurso));
    }

    public RecursoDTO modificarRecurso(RecursoDTO dto){
        if(dto.getTipoRecurso() == null){
            throw new RuntimeException("El tipo del recurso no puede ser nulo");
        }
        Recurso recurso = recursoRepository.save(recursoMapper.fromDTO(dto));
        return recursoMapper.fromCollection(recurso);
    }

    public List<RecursoDTO> obtenerRecurso(){
        return recursoMapper.fromCollectionList(recursoRepository.findAll());
    }

    public List<TematicaDTO> obtenerAreaTematica(){
        return areaMapper.fromCollectionList(areaTematicaRepository.findAll());
    }

    public String consultarRecurso(String id){
        var recurso = recursoRepository.findById(id);
        if(recurso.get().getDisponible()){
            return "El recurso esta disponible para prestamo";
        }
        return "El recurso fue prestado"+ recurso.get().getFechaPrestamo();
    }

    public void eliminarRecurso(String id){
        if(id == null){
            throw new RuntimeException("Debe tener un id al que eliminar");
        }
        recursoRepository.deleteById(id);
    }

}

