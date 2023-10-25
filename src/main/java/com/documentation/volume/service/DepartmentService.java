package com.documentation.volume.service;

import com.documentation.volume.model.Department;

import java.util.List;

public interface DepartmentService {
    void create(Department department);

    List<Department> readAll();

    Department read(int id);

    boolean update(Department department, int id);

    boolean delete(int id);
}
