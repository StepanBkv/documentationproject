package com.documentation.volume.mapper;

import com.documentation.volume.DTO.DepartmentDto;
import com.documentation.volume.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = FacultyMapper.class)
public interface DepartmentMapper {


    DepartmentDto toDto(Department department);


    Department toModel(DepartmentDto departmentDto);

}
