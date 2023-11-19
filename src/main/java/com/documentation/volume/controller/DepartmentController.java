package com.documentation.volume.controller;

import com.documentation.volume.DTO.DepartmentDto;
import com.documentation.volume.DTO.FacultyDto;
import com.documentation.volume.model.Department;
import com.documentation.volume.model.Faculty;
import com.documentation.volume.service.DepartmentService;
import com.documentation.volume.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    private final FacultyService facultyService;


    @PostMapping(value = "/faculties/{id}/departments")
    public ResponseEntity<?> create(@PathVariable(value = "id") int id, @RequestBody DepartmentDto departmentDto){

        FacultyDto faculty = facultyService.read(id);
        departmentDto.setFaculty(faculty);
        departmentService.create(departmentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/departments")
    public ResponseEntity<List<DepartmentDto>> read() {
        final List<DepartmentDto> departments = departmentService.readAll();

        return departments != null &&  !departments.isEmpty()
                ? new ResponseEntity<>(departments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/departments/{id}")
    public ResponseEntity<DepartmentDto> read(@PathVariable(name = "id") int id){
        final DepartmentDto department = departmentService.read(id);

        return department != null
                ? new ResponseEntity<>(department, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/departments/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody DepartmentDto departments) {
        final boolean updated = departmentService.update(departments, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/departments/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = departmentService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
