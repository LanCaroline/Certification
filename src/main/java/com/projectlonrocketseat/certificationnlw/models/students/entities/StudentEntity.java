package com.projectlonrocketseat.certificationnlw.models.students.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {

    private UUID id; //0186392b-03ca-4075-8674-3974f156f48b

    private String email;

    private List<CertificationEstudentEntity> certificationEstudentsEntities;


}
