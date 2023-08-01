package com.fernando.finance.controller;

import com.fernando.finance.model.dto.person.PersonRequestDto;
import com.fernando.finance.model.dto.person.PersonResponseDto;
import com.fernando.finance.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@CrossOrigin
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    private ResponseEntity<List<PersonResponseDto>> get() {
        return new ResponseEntity<>(personService.get(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<PersonResponseDto> save(@RequestBody PersonRequestDto personRequestDto) {
        return new ResponseEntity<>(personService.save(personRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<PersonResponseDto> update(
            @PathVariable int id,
            @RequestBody PersonRequestDto personRequestDto
    ) {
        return new ResponseEntity<>(personService.update(id, personRequestDto), HttpStatus.OK);
    }
}
