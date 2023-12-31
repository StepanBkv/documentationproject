package com.documentation.volume.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_number")
    private Integer number;

    @Column(name = "department_name")
    private String name;

    @Column(name = "department_short_name")
    private String shortName;


    @ManyToOne
    @JoinColumn(name="faculty_id")
    private Faculty faculty;


}
