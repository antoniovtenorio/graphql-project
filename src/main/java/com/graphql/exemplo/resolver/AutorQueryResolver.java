package com.graphql.exemplo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.exemplo.entities.Autor;
import com.graphql.exemplo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorQueryResolver implements GraphQLQueryResolver {
    private final AutorRepository autorRepository;

    @Autowired
    public AutorQueryResolver(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Iterable<Autor> findAllAutores() {
        return autorRepository.findAll();
    }

    public long contarAutores() {
        return autorRepository.count();
    }
}
