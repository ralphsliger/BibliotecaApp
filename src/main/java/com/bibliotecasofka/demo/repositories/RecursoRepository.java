package com.bibliotecasofka.demo.repositories;

import com.bibliotecasofka.demo.models.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecursoRepository extends MongoRepository<Recurso, String> {
}
