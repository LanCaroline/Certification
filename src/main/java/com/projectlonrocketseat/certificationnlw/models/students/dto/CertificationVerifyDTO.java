package com.projectlonrocketseat.certificationnlw.models.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificationVerifyDTO {
    private String email;
    private String technology;
}
