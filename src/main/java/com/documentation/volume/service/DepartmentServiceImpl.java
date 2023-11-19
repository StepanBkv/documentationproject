package com.documentation.volume.service;

import com.documentation.volume.DTO.DepartmentDto;
import com.documentation.volume.mapper.DepartmentMapper;
import com.documentation.volume.model.Department;
import com.documentation.volume.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Transactional
    @Override
    public void create(DepartmentDto departmentDto) {

        Department department = departmentMapper.toModel(departmentDto);
        departmentRepository.save(department);
    }
    @Transactional
    @Override
    public List<DepartmentDto> readAll() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream().map(departmentMapper::toDto).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public DepartmentDto read(int id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);

        Department department = optionalDepartment.isPresent() ?
                optionalDepartment.get(): null;

        return departmentMapper.toDto(department);
    }
    @Transactional
    @Override
    public boolean update(DepartmentDto departmentDto, int id) {
        if (departmentRepository.existsById(id)){
            Department department = departmentMapper.toModel(departmentDto);
            department.setId(id);
            departmentRepository.save(department);
            return true;
        }

        return false;
    }
    @Transactional
    @Override
    public boolean delete(int id) {
        if (departmentRepository.existsById(id)){
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
