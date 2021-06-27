package com.graphql.exemplo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.exemplo.entities.Autor;
import com.graphql.exemplo.entities.Tutorial;
import com.graphql.exemplo.repositories.TutorialRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class TutorialMutation  implements GraphQLMutationResolver {
    private final TutorialRepository tutorialRepository;

    @Autowired
    public TutorialMutation(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    public Tutorial criarTutorial(String titulo, String descricao, Long autorId)
    {
        Tutorial tutorial = new Tutorial(null, titulo, descricao, new Autor(autorId));
        tutorialRepository.save(tutorial);

        return tutorial;
    }

    public Tutorial atualizarTutorial(Long id, String titulo, String descricao) throws NotFoundException
    {
        Tutorial tutorial = tutorialRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("nenhum tutorial encontrado para atualizar"));
        if (titulo != null) { tutorial.setTitulo(titulo); }
        if (descricao != null) { tutorial.setDescricao(descricao); }

        tutorialRepository.save(tutorial);
        return tutorial;
    }

    public boolean deletarTutorial(Long id) {
        tutorialRepository.deleteById(id);
        return true;
    }

}
