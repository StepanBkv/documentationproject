package com.documentation.volume.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Entity
@Data
@Table(name = "faculty")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Faculty {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "faculty_name")
    private String name;

    @Column(name = "faculty_name_short")
    private String shortName;


}
