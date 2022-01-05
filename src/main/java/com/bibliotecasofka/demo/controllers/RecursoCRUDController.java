package com.bibliotecasofka.demo.controllers;

import com.bibliotecasofka.demo.dtos.RecursoDTO;
import com.bibliotecasofka.demo.dtos.TematicaDTO;
import com.bibliotecasofka.demo.services.RecursoCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecursoCRUDController {

    @Autowired
    private RecursoCRUDService service;

    @PostMapping("/recursos/crear")
    public ResponseEntity<RecursoDTO> crear(@RequestBody RecursoDTO recursos){
        return new ResponseEntity<>(service.crearRecurso(recursos), HttpStatus.CREATED);
    }
    @GetMapping("/recursos/consultar/{id}")
    public ResponseEntity<String> consultar(@PathVariable("id") String id){
        var respuesta = service.consultarRecurso(id);
        if(respuesta != null){
            return new ResponseEntity(respuesta, HttpStatus.OK);
        }
        return new ResponseEntity(respuesta, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/recursos")
    public ResponseEntity<List<RecursoDTO>> getAll(){
        return new ResponseEntity<>(service.obtenerRecurso(), HttpStatus.OK);
    }

    @GetMapping("/recursos/modificar/{id}")
    public ResponseEntity<RecursoDTO> modificar(@RequestBody RecursoDTO recursoDTO){
        if(recursoDTO.getIdRecurso() != null){
            return new ResponseEntity(service.modificarRecurso(recursoDTO), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   @DeleteMapping("recursos/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable("id") String id){
        try{
            service.eliminarRecurso(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
   }

   @PostMapping("/recursos/tematica/crear")
    public ResponseEntity<TematicaDTO> crearTematica(@RequestBody TematicaDTO tematicaDTO){
        return new ResponseEntity<>(service.crearAreaTematica(tematicaDTO), HttpStatus.CREATED);
   }

   @GetMapping("/recursos/tematicas")
    public ResponseEntity<List<TematicaDTO>> getAllTematica(){
        return new ResponseEntity<>(service.obtenerAreaTematica(), HttpStatus.OK);
   }
}
