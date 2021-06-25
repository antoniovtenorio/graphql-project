package com.graphql.exemplo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.exemplo.entities.Tutorial;
import com.graphql.exemplo.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialQueryResolver implements GraphQLQueryResolver {
    private final TutorialRepository tutorialRepository;

    @Autowired
    public TutorialQueryResolver(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    // busca a lista de tutoriais
    public Iterable<Tutorial> findAllTutoriais() {
        return tutorialRepository.findAll();
    }
    // conta quantos registros de tutoriais existem.
    public long contarTutoriais(){
        return tutorialRepository.count();
    }
}
