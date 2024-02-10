package com.projectlonrocketseat.certificationnlw.models.questions.controller;

import com.projectlonrocketseat.certificationnlw.models.questions.dto.AlternativesResultDTO;
import com.projectlonrocketseat.certificationnlw.models.questions.dto.QuestionResultDTO;
import com.projectlonrocketseat.certificationnlw.models.questions.entities.AlternativesEntity;
import com.projectlonrocketseat.certificationnlw.models.questions.entities.QuestionEntity;
import com.projectlonrocketseat.certificationnlw.models.questions.repositories.QuestionRespository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRespository questionRespository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){

        System.out.println("TECH ==="+technology);
        var result = this.questionRespository.findByTechnology(technology);

        var tomap = result.stream().map(question -> mapQuestionToDTO(question)).collect(Collectors.toList());
        return tomap;
    }

    static QuestionResultDTO mapQuestionToDTO(QuestionEntity question){

        var questionResultDTO = QuestionResultDTO.builder()
                .id(question.getId())
                .technology(question.getTechnology())
                .description(question.getDescription()).build();

        List<AlternativesResultDTO> alternativesResultDTOs = question.getAlternatives()
                .stream().map(alternative -> mapAlternativeDTO(alternative))
                .collect(Collectors.toList());

        questionResultDTO.setAlternatives(alternativesResultDTOs);
        return questionResultDTO;
    }

    static AlternativesResultDTO mapAlternativeDTO(AlternativesEntity alternativesResultDTO){

        return AlternativesResultDTO.builder()
                .id(alternativesResultDTO.getId())
                .description(alternativesResultDTO.getDescription()).build();
    }



}
