package com.bibliotecasofka.demo.repositories;

import com.bibliotecasofka.demo.models.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoRepository extends MongoRepository<Recurso, String> {

    List<Recurso> findAllByidTematica(String idTematica);

    List<Recurso> findAllBydisponible(boolean condicion);
}
