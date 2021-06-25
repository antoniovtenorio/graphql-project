package com.graphql.exemplo.repositories;

import com.graphql.exemplo.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
