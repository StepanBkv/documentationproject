package com.documentation.volume.DTO;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VersionDto {

    private Long id;
    private Date lastModifiedDate;
    private String versionNumber;
    private String academicYear;
    private Boolean umu;
    private Long departmentId;
}
