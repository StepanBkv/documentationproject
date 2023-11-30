package com.documentation.volume.service;


import com.documentation.volume.DTO.VersionDto;

import java.util.List;

public interface VersionService {

    VersionDto create(VersionDto version);

    List<VersionDto> readAll();

    List<VersionDto> findAllByDepartmentId(int id);

    VersionDto read(int id);

    VersionDto update(VersionDto version, int id);


    boolean delete(int id);
}
