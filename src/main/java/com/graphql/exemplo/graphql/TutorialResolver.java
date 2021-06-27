package com.graphql.exemplo.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.exemplo.entities.Autor;
import com.graphql.exemplo.entities.Tutorial;
import com.graphql.exemplo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {

    @Autowired
    private final AutorRepository autorRepository;

    public TutorialResolver(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor getAutor(Tutorial tutorial)
    {
        return autorRepository.findById(tutorial.getAutor().getId()).orElseThrow(()-> new RuntimeException("Erro ao localizar Autor"));
    }
}
