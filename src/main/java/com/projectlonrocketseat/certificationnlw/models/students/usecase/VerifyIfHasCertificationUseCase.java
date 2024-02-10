package com.projectlonrocketseat.certificationnlw.models.students.usecase;

import com.projectlonrocketseat.certificationnlw.models.students.dto.CertificationVerifyDTO;
import com.projectlonrocketseat.certificationnlw.models.students.repositories.CertificationEstudentRespositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {

    @Autowired
    private CertificationEstudentRespositories certificationEstudentRespositories;

    public boolean execute(CertificationVerifyDTO dto){
        var result = this.certificationEstudentRespositories.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());

        if(!result.isEmpty()){
            return true;
        }
        return false;
    }

}
