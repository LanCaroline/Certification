package com.projectlonrocketseat.certificationnlw.models.students.controllers;

import com.projectlonrocketseat.certificationnlw.models.students.dto.CertificationVerifyDTO;
import com.projectlonrocketseat.certificationnlw.models.students.usecase.VerifyIfHasCertificationUseCase;
import com.projectlonrocketseat.certificationnlw.models.students.entities.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentCotroller {

    // in here we need use the use case
    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestHeader CertificationVerifyDTO certificationVerifyDTO){
        //Email
        //Technology

        var result = this.verifyIfHasCertificationUseCase.execute(certificationVerifyDTO);
        if(result){
            return "Usuário já fez a prova.";
        }
        //System.out.println(certificationVerifyDTO);
        return "Usuário pode fazer a prova.";
    }


}
