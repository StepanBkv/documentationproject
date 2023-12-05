package com.documentation.volume.repository;

import com.documentation.volume.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VersionRepository extends JpaRepository<Version,Long> {

    List<Version> findAllByDepartmentId(Long Id);
}
