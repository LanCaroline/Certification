package com.projectlonrocketseat.certificationnlw.models.questions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionsAnswerDTO {

    private UUID questionID;
    private UUID alternativeID;
    private boolean isCorrect;

}