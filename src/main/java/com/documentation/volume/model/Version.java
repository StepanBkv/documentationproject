package com.documentation.volume.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "version")
@AllArgsConstructor
@NoArgsConstructor
public class Version {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "version_number")
    private String versionNumber;

    @Column(name = "academic_year")
    private String academicYear;

    @Column(name = "Sign_confirmation_delivery_UMU")
    private Boolean umu;

    @Column(name = "department_id")
    private Long departmentId;
}
