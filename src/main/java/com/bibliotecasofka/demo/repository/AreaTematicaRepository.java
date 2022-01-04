package com.bibliotecasofka.demo.repository;

import com.bibliotecasofka.demo.model.Tematica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AreaTematicaRepository extends MongoRepository<Tematica, String> {
}
