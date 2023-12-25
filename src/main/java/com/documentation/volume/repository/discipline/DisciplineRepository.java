package com.documentation.volume.repository.discipline;

import com.documentation.volume.model.discipline.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    List<Discipline> findAllByVersionId(Long Id);
}
