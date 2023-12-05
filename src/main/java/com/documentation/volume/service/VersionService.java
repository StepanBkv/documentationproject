package com.documentation.volume.service;


import com.documentation.volume.DTO.VersionDto;

import java.util.List;

public interface VersionService {

    VersionDto create(VersionDto version);

    List<VersionDto> readAll();

    List<VersionDto> findAllByDepartmentId(Long id);

    VersionDto read(Long id);

    VersionDto update(VersionDto version, Long id);


    boolean delete(Long id);
}
