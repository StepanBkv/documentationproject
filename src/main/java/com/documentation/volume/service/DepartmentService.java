package com.documentation.volume.service;

import com.documentation.volume.DTO.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto create(DepartmentDto department);

    List<DepartmentDto> readAll();

    DepartmentDto read(int id);

    DepartmentDto update(DepartmentDto department, int id);

    boolean delete(int id);
}
