package com.documentation.volume.service;

import com.documentation.volume.DTO.FacultyDto;

import java.util.List;

public interface FacultyService {

    FacultyDto create(FacultyDto faculty);

    List<FacultyDto> readAll();

    FacultyDto read(Long id);

    FacultyDto update(FacultyDto faculty, Long id);

    boolean delete(Long id);
}
