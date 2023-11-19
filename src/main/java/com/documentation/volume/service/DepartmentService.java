package com.documentation.volume.service;

import com.documentation.volume.DTO.DepartmentDto;
import com.documentation.volume.model.Department;

import java.util.List;

public interface DepartmentService {
    void create(DepartmentDto department);

    List<DepartmentDto> readAll();

    DepartmentDto read(int id);

    boolean update(DepartmentDto department, int id);

    boolean delete(int id);
}
