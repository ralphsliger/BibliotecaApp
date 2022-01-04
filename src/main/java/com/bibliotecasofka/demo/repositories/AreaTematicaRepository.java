package com.bibliotecasofka.demo.repositories;

import com.bibliotecasofka.demo.models.Tematica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AreaTematicaRepository extends MongoRepository<Tematica, String> {
}
