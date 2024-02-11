package com.projectlonrocketseat.certificationnlw.models.certifications.controllers;

import com.projectlonrocketseat.certificationnlw.models.certifications.usecases.Top10RankingUseCases;
import com.projectlonrocketseat.certificationnlw.models.students.entities.CertificationEstudentEntity;
import com.projectlonrocketseat.certificationnlw.models.students.repositories.CertificationEstudentRespositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTMLEditorKit;
import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private Top10RankingUseCases top10RankingUseCases;

    @GetMapping("/top10")
    public List<CertificationEstudentEntity> top10(){
        return this.top10RankingUseCases.execute();
    }
}
