package com.documentation.volume.mapper;

import com.documentation.volume.DTO.FacultyDto;
import com.documentation.volume.model.Faculty;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultyMapper {
    FacultyDto toDto(Faculty faculty);
    Faculty toModel(FacultyDto facultyDto);
}
