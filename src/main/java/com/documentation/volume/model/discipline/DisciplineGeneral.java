package com.documentation.volume.model.discipline;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
@Data
@Table(name = "discipline_general")
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "version_id")
    private Long versionId;

    @Column(name = "speciality_id")
    private Long specialityId;

    @Column(name = "contingent_id")
    private Long contingentId;

    @Column(name = "discipline_name", nullable = false)
    private String disciplineName;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "course")
    private Integer course;
}
