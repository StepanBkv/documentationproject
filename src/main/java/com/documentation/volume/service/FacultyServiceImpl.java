package com.documentation.volume.service;

import com.documentation.volume.model.Department;
import com.documentation.volume.model.Faculty;
import com.documentation.volume.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public void create(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> readAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty read(int id) {
        return facultyRepository.getOne(id);
    }

    @Override
    public boolean update(Faculty faculty, int id) {
        if (facultyRepository.existsById(id)){
            faculty.setId(id);
            facultyRepository.save(faculty);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (facultyRepository.existsById(id)){
            facultyRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
