package com.graphql.exemplo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.exemplo.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialMutation  implements GraphQLMutationResolver {
    private final TutorialRepository tutorialRepository;

    @Autowired
    public TutorialMutation(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }


}
