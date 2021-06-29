package com.graphql.exemplo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.exemplo.entities.Autor;
import com.graphql.exemplo.entities.Tutorial;
import com.graphql.exemplo.repositories.TutorialRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class TutorialGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private TutorialRepository tutorialRepository;

    // busca a lista de tutoriais
    public Iterable<Tutorial> findAllTutoriais() {
        return tutorialRepository.findAll();
    }

    // conta quantos registros de tutoriais existem.
    public long contarTutoriais(){
        return tutorialRepository.count();
    }


    public Tutorial criarTutorial(String titulo, String descricao, Long autorId)
    {
        Tutorial tutorial = new Tutorial(null, titulo, descricao, new Autor(autorId));
        tutorialRepository.save(tutorial);

        return tutorial;
    }

    public Tutorial atualizarTutorial(int id, String titulo, String descricao) throws NotFoundException
    {
        Tutorial tutorial = tutorialRepository.findById((long) id)
                .orElseThrow(() -> new NotFoundException("nenhum tutorial encontrado para atualizar"));
        if (titulo != null) { tutorial.setTitulo(titulo); }
        if (descricao != null) { tutorial.setDescricao(descricao); }

        tutorialRepository.save(tutorial);
        return tutorial;
    }

    public boolean deleteTutorial(int id) {
        tutorialRepository.deleteById((long) id);
        return true;
    }

}
