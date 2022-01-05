package com.bibliotecasofka.demo.services;

import com.bibliotecasofka.demo.dtos.ListarRecursoDeTematicaDTO;
import com.bibliotecasofka.demo.dtos.ListarTematicaDTO;
import com.bibliotecasofka.demo.dtos.RespuestaDTO;
import com.bibliotecasofka.demo.mappers.RecursoBibliotecaMapper;
import com.bibliotecasofka.demo.models.Recurso;
import com.bibliotecasofka.demo.models.Tematica;
import com.bibliotecasofka.demo.repositories.AreaTematicaRepository;
import com.bibliotecasofka.demo.repositories.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    @Autowired
    private AreaTematicaRepository areaRepository;

    private RecursoBibliotecaMapper mapper = new RecursoBibliotecaMapper();

    private LocalDate localDate = LocalDate.now();//For reference
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
    private  String formattedString = localDate.format(formatter);

    private RespuestaDTO disponibilidad(String id){

        RespuestaDTO respuesta = new RespuestaDTO();

        var recurso = recursoRepository.findById(id);

        if(recurso.get().getDisponible()){
            respuesta.setRespuesta("El recurso:" + mapper.fromCollection(recurso.get()).getNombre() +"esta disponible para prestamo");
            respuesta.setDisponible(true);
            respuesta.setFechaPrestamo(null);
            return respuesta;
        }
        respuesta.setRespuesta("el recurso no esta disponible para prestamo");
        respuesta.setDisponible(false);
        respuesta.setFechaPrestamo(mapper.fromCollection(recurso.get()).getFechaPrestamo());
        return respuesta;
    }

    public RespuestaDTO prestar(String id){

        RespuestaDTO respuesta = new RespuestaDTO();

        Recurso recurso = recursoRepository.findById(id).orElseThrow(()->new RuntimeException("no encontado"));

        if(recurso.getDisponible()){
            recurso.setDisponible(false);
            recurso.setFechaPrestamo(formattedString);
            recursoRepository.save(recurso);
            respuesta.setRespuesta("El recurso fue prestado");
            respuesta.setDisponible(false);
            respuesta.setFechaPrestamo(formattedString);
            return respuesta;
        }

        respuesta.setRespuesta("El recurso se encuentra en prestamo en el momento");
        respuesta.setDisponible(false);
        respuesta.setFechaPrestamo(formattedString);

        return respuesta;
    }

    public RespuestaDTO devolver(String id){

        RespuestaDTO respuesta = new RespuestaDTO();

        var recurso = recursoRepository.findById(id);

        if(!recurso.get().getDisponible()){
            recurso.get().setDisponible(true);
            recurso.get().setFechaPrestamo(formattedString);
            recursoRepository.save(recurso.get());
            respuesta.setRespuesta("Ha sido devuelto");
            respuesta.setDisponible(true);
            respuesta.setFechaPrestamo(formattedString);
        }

        respuesta.setRespuesta("No ha sido devuelto");
        respuesta.setDisponible(false);
        respuesta.setFechaPrestamo(formattedString);

        return respuesta;
    }

    public ListarRecursoDeTematicaDTO recomendar(String idTematica) {

        ListarRecursoDeTematicaDTO recursosAreaTematica = new ListarRecursoDeTematicaDTO();
        var areaTematica = areaRepository.findById(idTematica).orElseThrow(() -> new RuntimeException("No se encontro el area tematica"));
        var list = recursoRepository.findAllByidTematica(idTematica);
        recursosAreaTematica.setTipoTematica(areaTematica.getCategoria());
        recursosAreaTematica.setRecursos(mapper.fromCollectionList(list));
        return recursosAreaTematica;
    }

    public ListarTematicaDTO recomendarPorCondicion(boolean condicion){
        ListarTematicaDTO listarTematicaDTO = new ListarTematicaDTO();
        var list = recursoRepository.findAllBydisponible(condicion);
        listarTematicaDTO.setRecursosTematica(mapper.fromCollectionList(list));
        listarTematicaDTO.setTematica(condicion ? "Disponible": "No Disponible");
        return listarTematicaDTO;
    }
}