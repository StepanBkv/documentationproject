package com.documentation.volume.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    private Integer number;
    private String name;
    private String shortName;
    private FacultyDto faculty;
}
