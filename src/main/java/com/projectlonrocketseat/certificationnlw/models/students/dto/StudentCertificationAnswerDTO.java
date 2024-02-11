package com.projectlonrocketseat.certificationnlw.models.students.dto;

import com.projectlonrocketseat.certificationnlw.models.questions.dto.QuestionsAnswerDTO;
import com.projectlonrocketseat.certificationnlw.models.questions.entities.QuestionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.SplittableRandom;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCertificationAnswerDTO {

    private String email;
    private String technology;

    private List<QuestionsAnswerDTO> questionsAnswers;

}
