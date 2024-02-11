package com.projectlonrocketseat.certificationnlw.models.certifications.usecases;

import com.projectlonrocketseat.certificationnlw.models.students.entities.CertificationEstudentEntity;
import com.projectlonrocketseat.certificationnlw.models.students.repositories.CertificationEstudentRespositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Top10RankingUseCases {

    @Autowired
    private CertificationEstudentRespositories certificationEstudentRespositories;

    public List<CertificationEstudentEntity> execute(){

        var result = this.certificationEstudentRespositories.findTop10ByOrderByGradeDesc();
        return result;
    }

}
