package com.documentation.volume.controller;

import com.documentation.volume.DTO.FacultyDto;
import com.documentation.volume.model.Faculty;
import com.documentation.volume.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService){
        this.facultyService = facultyService;
    }

    @PostMapping(value = "/faculties")
    public ResponseEntity<?> create(@RequestBody FacultyDto faculty){
        FacultyDto facultyDtoResponse = facultyService.create(faculty);
        return new ResponseEntity<>(facultyDtoResponse,HttpStatus.CREATED);
    }

    @GetMapping(value = "/faculties")
    public ResponseEntity<List<FacultyDto>> read() {
        final List<FacultyDto> faculties = facultyService.readAll();

        return faculties != null &&  !faculties.isEmpty()
                ? new ResponseEntity<>(faculties, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/faculties/{id1}")
    public ResponseEntity<FacultyDto> read(@PathVariable(name = "id1") Long id){
        final FacultyDto faculty = facultyService.read(id);

        return faculty != null
                ? new ResponseEntity<>(faculty, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/faculties/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody FacultyDto faculty) {
        final FacultyDto FacultyDtoResponse = facultyService.update(faculty, id);

        return FacultyDtoResponse != null
                ? new ResponseEntity<>(FacultyDtoResponse,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/faculties/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = facultyService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
