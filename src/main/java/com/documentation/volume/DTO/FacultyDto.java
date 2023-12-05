package com.documentation.volume.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    private Long id;

    private String name;

    private String shortName;
}
