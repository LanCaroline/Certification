package com.projectlonrocketseat.certificationnlw.models.students.controllers;

import com.projectlonrocketseat.certificationnlw.models.students.dto.CertificationVerifyDTO;
import com.projectlonrocketseat.certificationnlw.models.students.dto.StudentCertificationAnswerDTO;
import com.projectlonrocketseat.certificationnlw.models.students.entities.CertificationEstudentEntity;
import com.projectlonrocketseat.certificationnlw.models.students.repositories.StudentRepositories;
import com.projectlonrocketseat.certificationnlw.models.students.usecase.StudentCertificationAnswersUseCase;
import com.projectlonrocketseat.certificationnlw.models.students.usecase.VerifyIfHasCertificationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public CertificationEstudentEntity certificationAnswer(@RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
        return this.studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);

    }


}
