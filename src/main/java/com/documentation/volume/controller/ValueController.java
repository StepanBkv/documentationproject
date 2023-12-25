package com.documentation.volume.controller;

import com.documentation.volume.DTO.ValueDto;
import com.documentation.volume.service.ValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class ValueController {

    private final ValueService valueService;

    @GetMapping(value = "/value/versions/{id}")
    public ResponseEntity<ValueDto> read(@PathVariable(name = "id") Long id){
        final ValueDto valueDto = valueService.read(id);

        return valueDto != null
                ? new ResponseEntity<>(valueDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
