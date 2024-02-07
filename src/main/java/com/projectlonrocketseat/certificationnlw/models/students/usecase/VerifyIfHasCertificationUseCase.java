package com.projectlonrocketseat.certificationnlw.models.students.usecase;

import com.projectlonrocketseat.certificationnlw.models.students.dto.CertificationVerifyDTO;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {

    public boolean execute(CertificationVerifyDTO dto){
        if(dto.getEmail().equals("dalieneleon@gmail.com") && dto.getTechnology().equals("JAVA")){
            return true;
        }
        return false;
    }

}
