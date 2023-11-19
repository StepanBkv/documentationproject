package com.documentation.volume.service;

import com.documentation.volume.DTO.FacultyDto;
import com.documentation.volume.mapper.FacultyMapper;
import com.documentation.volume.model.Faculty;
import com.documentation.volume.repository.FacultyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private FacultyMapper facultyMapper;
    @Transactional
    @Override
    public void create(FacultyDto facultyDto) {

        Faculty faculty = facultyMapper.toModel(facultyDto);

        facultyRepository.save(faculty);
    }
    @Transactional
    @Override
    public List<FacultyDto> readAll() {

        List<Faculty> faculties = facultyRepository.findAll();
        faculties.sort(Comparator.comparing((Faculty::getId)));

        return faculties.stream().map(facultyMapper::toDto).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public FacultyDto read(int id) {

        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        Faculty faculty = optionalFaculty.isPresent() ?
                optionalFaculty.get(): null;;

        return facultyMapper.toDto(faculty);
    }
    @Transactional
    @Override
    public boolean update(FacultyDto facultyDto, int id) {


        if (facultyRepository.existsById(id)){
            Faculty faculty = facultyRepository.findById(id).get();
            faculty.setName(facultyDto.getName());
            faculty.setShortName(facultyDto.getShortName());
            facultyRepository.save(faculty);
            return true;
        }

        return false;
    }
    @Transactional
    @Override
    public boolean delete(int id) {
        if (facultyRepository.existsById(id)){
            facultyRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
