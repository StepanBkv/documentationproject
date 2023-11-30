package com.documentation.volume.repository;

import com.documentation.volume.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VersionRepository extends JpaRepository<Version,Integer> {

    List<Version> findAllByDepartmentId(Integer Id);
}
