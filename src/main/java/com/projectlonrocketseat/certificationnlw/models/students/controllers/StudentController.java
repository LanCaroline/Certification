package com.projectlonrocketseat.certificationnlw.models.students.controllers;

import com.projectlonrocketseat.certificationnlw.models.students.dto.CertificationVerifyDTO;
import com.projectlonrocketseat.certificationnlw.models.students.dto.StudentCertificationAnswerDTO;
import com.projectlonrocketseat.certificationnlw.models.students.entities.CertificationEstudentEntity;
import com.projectlonrocketseat.certificationnlw.models.students.repositories.StudentRepositories;
import com.projectlonrocketseat.certificationnlw.models.students.usecase.StudentCertificationAnswersUseCase;
import com.projectlonrocketseat.certificationnlw.models.students.usecase.VerifyIfHasCertificationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/student")
public class StudentController {

    // in here we need use the use case
    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @Autowired
    private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody CertificationVerifyDTO certificationVerifyDTO){
        //Email
        //Technology

        var result = this.verifyIfHasCertificationUseCase.execute(certificationVerifyDTO);
        if(result){
            return "Usuário já fez a prova.";
        }
        //System.out.println(certificationVerifyDTO);
        return "Usuário pode fazer a prova.";
    }

    @RequestMapping("/certification/answer")
    public ResponseEntity<Object> certificationAnswer(@RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO){
        try{
            var result = this.studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
