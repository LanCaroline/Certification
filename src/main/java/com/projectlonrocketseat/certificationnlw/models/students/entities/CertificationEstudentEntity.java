package com.projectlonrocketseat.certificationnlw.models.students.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificationEstudentEntity {
    private UUID id;
    private UUID student_id;
    private String technology;
    private int grate;
    List<AnswersCertificationEntity> answersCertificationEntities;


}
