package com.documentation.volume.controller;


import com.documentation.volume.DTO.VersionDto;
import com.documentation.volume.service.VersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class VersionController {
    private final VersionService versionService;

    @PostMapping(value = "/versions")
    public ResponseEntity<?> create(@RequestBody VersionDto versionDto){

        VersionDto versionDtoResponse = versionService.create(versionDto);
        return new ResponseEntity<>(versionDtoResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/versions")
    public ResponseEntity<List<VersionDto>> read() {
        final List<VersionDto> versions = versionService.readAll();

        return versions != null &&  !versions.isEmpty()
                ? new ResponseEntity<>(versions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/versions/findByDep/{depId}")
    public ResponseEntity<List<VersionDto>> findAllByDepartmentId(@PathVariable(name = "depId") Long id) {
        final List<VersionDto> versions = versionService.findAllByDepartmentId(id);

        return versions != null &&  !versions.isEmpty()
                ? new ResponseEntity<>(versions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/versions/{id}")
    public ResponseEntity<VersionDto> read(@PathVariable(name = "id") Long id){
        final VersionDto versionDto = versionService.read(id);

        return versionDto != null
                ? new ResponseEntity<>(versionDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/versions/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody VersionDto versionDto) {
        final VersionDto versionDtoResponse = versionService.update(versionDto, id);

        return versionDtoResponse != null
                ? new ResponseEntity<>(versionDtoResponse,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/versions/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = versionService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
