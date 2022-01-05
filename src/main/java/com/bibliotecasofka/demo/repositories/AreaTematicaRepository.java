package com.bibliotecasofka.demo.repositories;

import com.bibliotecasofka.demo.models.Tematica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaTematicaRepository extends MongoRepository<Tematica, String> {
}
