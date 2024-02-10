package com.projectlonrocketseat.certificationnlw.models.students.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "certification")
public class CertificationEstudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 100)
    private String technology;
    @Column(length = 100)
    private int grade;

    @JoinColumn(name= "student_id")
    private UUID studentID;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentEntity studentEntity;

    @OneToMany
    @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
    List<AnswersCertificationEntity> answersCertificationEntities;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
