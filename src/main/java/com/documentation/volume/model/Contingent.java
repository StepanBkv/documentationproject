package com.documentation.volume.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "contingent")
@AllArgsConstructor
@NoArgsConstructor
public class Contingent {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "speciality_id")
    private Integer speciality_id;

    @NotNull
    @Column(name = "course_number")
    private Integer course_number;

    @Column(name = "academic_year")
    private String academic_year;

    @Column(name = "version_id")
    private Integer version_id;

    @Column(name = "number_lecture_streams")
    private Integer number_lecture_streams;

    @Column(name = "contingent_budget")
    private Integer contingent_budget;

    @Column(name = "contingent_contract")
    private Integer contingent_contract;

    @Column(name = "number_groups")
    private Integer number_groups;

    @Column(name = "number_subgroups")
    private Integer number_subgroups;

    @Column(name = "number_profiles")
    private Integer number_profiles;

    @Column(name = "number_groups_practice")
    private Integer number_groups_practice;

}
