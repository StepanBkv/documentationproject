package com.documentation.volume.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionDto {

    private Integer id;
    private Date lastModifiedDate;
    private String versionNumber;
    private String academicYear;
    private Boolean umu;
    private Integer departmentId;
}
