package com.documentation.volume.DTO;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValueDto {
    private Long id;
    private String academicYear;
    private String specialityCode;
    private String disciplineCode;
    private String discipline_name;
    private Integer version_id;
    private Integer contingentBudget;
    private Integer contingentContract;
    private Integer budgetValueLecture;
    private Integer contractValueLecture;
    private Integer budgetValueLaboratory;
    private Integer contractValueLaboratory;
    private Double exam;
    private Double offset;
    private Double consultation_exam;
    private Double budget;
    private Double contract;
    private Double valueAll;
}
