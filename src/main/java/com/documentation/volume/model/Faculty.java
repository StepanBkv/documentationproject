package com.documentation.volume.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Entity
@Data
@Table(name = "faculty")
public class Faculty {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "facultyName")
    private String name;

    @Column(name = "facultyNameShort")
    private String shortName;






}
