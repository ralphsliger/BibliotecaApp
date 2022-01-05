package com.bibliotecasofka.demo.controllers;

import com.bibliotecasofka.demo.dtos.ListarRecursoDeTematicaDTO;
import com.bibliotecasofka.demo.dtos.RespuestaDTO;
import com.bibliotecasofka.demo.services.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class RecursoController {
    @Autowired
    private RecursoService service;

    @PutMapping("/recursos/prestar/{id}")
    public ResponseEntity<RespuestaDTO> prestar(@PathVariable("id") String id){
        var respuesta = service.prestar(id);
        if (respuesta != null){
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/recursos/devolver/{id}")
    public ResponseEntity<String> devolver(@PathVariable("id") String id){
        var respuesta = service.devolver(id);
        if (respuesta != null){
            return new ResponseEntity(respuesta, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/recursos/recomendar/{id}")
    public ResponseEntity<ListarRecursoDeTematicaDTO> recomendar(@PathVariable("id") String id){
        var respuesta = service.recomendar(id);
        if(respuesta != null){
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/recursos/disponibilidad/{id}")
    public ResponseEntity<ListarRecursoDeTematicaDTO> disponible(@PathVariable("id") Boolean condicion){
        var respuesta = service.recomendarPorCondicion(condicion);
        if(respuesta.getRecursosTematica().isEmpty()){
            return new ResponseEntity(respuesta, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

}
