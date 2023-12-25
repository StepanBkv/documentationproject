package com.documentation.volume.model;

import jakarta.persistence.*;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "speciality")
@AllArgsConstructor
@NoArgsConstructor

public class Speciality {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "speciality_code")
    private String speciality_code;

    @Column(name = "speciality_name")
    private String speciality_name;

    @Column(name = "speciality_short_name")
    private String speciality_short_name;

    @Column(name = "faculty_id")
    private long faculty_id;
}
