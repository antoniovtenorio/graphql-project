package com.graphql.exemplo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.exemplo.entities.Autor;
import com.graphql.exemplo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private AutorRepository autorRepository;

    public Autor criarAutor(String nome, Integer idade)
    {
        Autor autor = new Autor(null, nome, idade);
        autorRepository.save(autor);
        return autor;
    }

    public Iterable<Autor> findAllAutor() {
        return autorRepository.findAll();
    }

    public long contarAutores() {
        return autorRepository.count();
    }
}
