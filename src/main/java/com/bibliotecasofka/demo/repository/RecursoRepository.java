package com.bibliotecasofka.demo.repository;

import com.bibliotecasofka.demo.model.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecursoRepository extends MongoRepository<Recurso, String> {
}
