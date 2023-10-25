package com.documentation.volume.service;

import com.documentation.volume.model.Department;
import com.documentation.volume.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void create(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public List<Department> readAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department read(int id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public boolean update(Department department, int id) {
        if (departmentRepository.existsById(id)){
            department.setId(id);
            departmentRepository.save(department);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (departmentRepository.existsById(id)){
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
