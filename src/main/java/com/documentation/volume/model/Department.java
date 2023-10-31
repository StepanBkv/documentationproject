package com.documentation.volume.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "department")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "department_name")
    private String name;

    @ManyToOne
    @JoinColumn(name="faculty_id")
    private Faculty faculty;


}
