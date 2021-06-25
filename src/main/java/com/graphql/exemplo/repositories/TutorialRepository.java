package com.graphql.exemplo.repositories;

import com.graphql.exemplo.entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
