package com.projectlonrocketseat.certificationnlw.models.questions.repositories;

import com.projectlonrocketseat.certificationnlw.models.questions.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRespository extends JpaRepository<QuestionEntity, UUID> {

    List<QuestionEntity> findByTechnology(String technology);




}
