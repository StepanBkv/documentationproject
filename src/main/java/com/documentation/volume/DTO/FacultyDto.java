package com.documentation.volume.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    private Integer id;

    private String name;

    private String shortName;
}
