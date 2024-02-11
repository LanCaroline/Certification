package com.projectlonrocketseat.certificationnlw.models.students.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "student")
@Builder
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String email;

    // OneToOne
    // OneToMany
    // ManyToOne
    // ManyToMany

    @OneToMany(mappedBy = "studentEntity")
    private List<CertificationEstudentEntity> certificationEstudentsEntity;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
