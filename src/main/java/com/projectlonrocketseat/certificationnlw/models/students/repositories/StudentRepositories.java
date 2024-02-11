package com.projectlonrocketseat.certificationnlw.models.students.repositories;

import com.projectlonrocketseat.certificationnlw.models.questions.repositories.QuestionRespository;
import com.projectlonrocketseat.certificationnlw.models.students.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepositories extends JpaRepository<StudentEntity, UUID> {

    public Optional<StudentEntity> findByEmail(String email);



}
