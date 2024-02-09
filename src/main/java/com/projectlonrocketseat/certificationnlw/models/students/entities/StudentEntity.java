package com.projectlonrocketseat.certificationnlw.models.students.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; //0186392b-03ca-4075-8674-3974f156f48b
    @Column(unique = true, nullable = false)
    private String email;

    // OneToOne
    // OneToMany
    // ManyToOne
    // ManyToMany

    @OneToMany//(mappedBy = )
    private List<CertificationEstudentEntity> certificationEstudentsEntity;


}
