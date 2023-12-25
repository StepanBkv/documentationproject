package com.documentation.volume.model.discipline;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "discipline")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discipline extends DisciplineGeneral {

    @Column(name = "discipline_code")
    private String disciplineCode;

    @ManyToOne
    @JoinColumn(name = "control_type_id")
    private ControlType controlType;

    @Column(name = "lecture")
    private Integer lecture;

    @Column(name = "laboratory")
    private Integer laboratory;

    @Column(name = "practical")
    private Integer practical;

}
