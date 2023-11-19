package com.documentation.volume.service;

import com.documentation.volume.DTO.FacultyDto;
import com.documentation.volume.model.Faculty;

import java.util.List;

public interface FacultyService {

    void create(FacultyDto faculty);

    List<FacultyDto> readAll();

    FacultyDto read(int id);

    boolean update(FacultyDto faculty, int id);

    boolean delete(int id);
}
