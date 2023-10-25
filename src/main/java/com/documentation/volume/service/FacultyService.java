package com.documentation.volume.service;

import com.documentation.volume.model.Faculty;

import java.util.List;

public interface FacultyService {

    void create(Faculty faculty);

    List<Faculty> readAll();

    Faculty read(int id);

    boolean update(Faculty faculty, int id);

    boolean delete(int id);
}
