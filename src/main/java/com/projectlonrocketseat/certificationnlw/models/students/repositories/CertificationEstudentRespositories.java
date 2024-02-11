package com.projectlonrocketseat.certificationnlw.models.students.repositories;

import com.projectlonrocketseat.certificationnlw.models.students.entities.CertificationEstudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.UUID;

@Repository
public interface CertificationEstudentRespositories extends JpaRepository<CertificationEstudentEntity, UUID> {


    @Query("SELECT c FROM certification c INNER JOIN c.studentEntity std WHERE std.email = :email AND c.technology = :technology")
    List<CertificationEstudentEntity> findByStudentEmailAndTechnology(String email, String technology);

    @Query("SELECT c FROM certification c ORDER BY c.grade DESC LIMIT 10")
    List<CertificationEstudentEntity> findTop10ByOrderByGradeDesc();

}
