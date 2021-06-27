package com.graphql.exemplo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.exemplo.entities.Autor;
import com.graphql.exemplo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorMutation implements GraphQLMutationResolver {
    private AutorRepository autorRepository;

    @Autowired
    public AutorMutation(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor criarAutor(String nome, Integer idade)
    {
        Autor autor = new Autor(nome, idade);
        autorRepository.save(autor);
        return autor;
    }
}
